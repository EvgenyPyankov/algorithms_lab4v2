public class FordFulkerson {
    final int INFINITY = 9999999;
    int n;
    int[]Flow;  // Flow - �������� ������ ����� ������ ������� �� ������ ���� ������
    int[]Link;   // Link[i] ������ ����� ���������� ������ �� ���� i -> �����
    int[] Queue; // �������
    int QP, QC;              // QP - ��������� ������ ������� � QC - ����� ��-��� � �������
    int[][] f;  // f[i][j] - �����, ������� �� ������� i � j
    int[][] c;  // c[i][j] - ������������ �������� ������, ��������� ���� �� ����� (i,j)

    public FordFulkerson(int n, int[][]f,int[][]c){
        this.n=n;
        Flow = new int[n];
        Link = new int[n];
        Queue = new int[n];
        this.f=f;
        this.c=c;
        init();
    }

    private void init(){

        for (int i=0; i<f.length; i++)
            for (int j=0; j<f.length; j++){
                f[i][j]=0;
            }
    }
    int FindPath(int source, int target) // source - �����, target - ����
    {
        QP = 0; QC = 1; Queue[0] = source;
        Link[target] = -1;
        int CurVertex;
        for (int i=0; i<Flow.length; i++){
            Flow[i]=0;
        }
        Flow[source] = INFINITY;
        while ((Link[target] == -1) && (QP < QC))
        {
            CurVertex = Queue[QP];
            for (int i=0; i<n; i++)
                if ((c[CurVertex][i] - f[CurVertex][i])>0 && Flow[i] == 0)
                {
                    Queue[QC] = i; QC++;
                    Link[i] = CurVertex;
                    if ((c[CurVertex][i]-f[CurVertex][i]) < Flow[CurVertex])
                        Flow[i] = c[CurVertex][i];
                    else
                        Flow[i] = Flow[CurVertex];
                }
            QP++;

        }

        if (Link[target] == -1) return 0;
        CurVertex = target;
        while (CurVertex != source)
        {
            f[Link[CurVertex]][CurVertex] +=Flow[target];
            CurVertex = Link[CurVertex];
        }
        return Flow[target];


    }

    int MaxFlow(int source, int target) // source - �����, target - ����
    {
        int MaxFlow = 0;
        int AddFlow;
        do
        {
            AddFlow = FindPath(source, target);
            MaxFlow += AddFlow;
        } while (AddFlow >0);
        return MaxFlow;
    }
}
