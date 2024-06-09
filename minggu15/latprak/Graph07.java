package minggu15.latprak;

public class Graph07 {
    int vertex;
    DoubleLinkedLists07 list[];

    public Graph07(int v) {
        vertex = v;
        list = new DoubleLinkedLists07[v];
        for(int i = 0; i < v; i++) {
            list[i] = new DoubleLinkedLists07();
        }
    }

    public void addEdge(int asal, int tujuan, int jarak) {
        list[asal].addFirst(tujuan, jarak);
        System.out.println("Edge Berhasil Ditambahkan!\n");
        // undirect graph
        //list[tujuan].addFirst(asal, jarak);
    }
    
    public void degree(int asal) throws Exception {
        int k , totalIn = 0, totalOut = 0;
        for(int i = 0 ; i < vertex; i++) {
            // inDegree
            for(int j = 0; j < list[i].size(); j++) {
                if(list[i].get(j) == asal) {
                    ++totalIn;
                }
            }
            // outDegree
            for(k = 0; k < list[asal].size(); k++) {
                list[asal].get(k);
            }
            totalOut = k;
        }
        System.out.println("InDegree dari Gedung " + (char) ('A' + asal) + ": " + totalIn);
        System.out.println("OutDegree dari Gedung " + (char) ('A' + asal) + ": " + totalOut);
        System.out.println("Degree dari Gedung " + (char) ('A' + asal) + ": " + (totalOut + totalIn));
        // Undirect Graph
        // System.out.println("Degree dari Gedung " + (char) ('A' + asal) + ": " + list[asal].size());
    }

    public void removeEdge(int asal, int tujuan) throws Exception {
        for(int i = 0; i < vertex; i++) {
            if(i == tujuan) {
                list[asal].remove(tujuan);
            }
        }
        System.out.println("Edge Berhasil Dihapus!\n");
    }

    public void removeAllEdge() {
        for(int i = 0; i < vertex; i++) {
            list[i].clear();
        }
        System.out.println("Graph Berhasil Dikosongkan!\n");
    }

    public void printGraph() throws Exception {
        for(int i = 0; i < vertex; i++) {
            if(list[i].size() > 0) {
                System.out.println("Gedung " + (char) ('A' + i) + " terhubung dengan ");
                for(int j = 0; j < list[i]. size(); j++) {
                    System.out.print((char) ('A' + list[i].get(j)) + " (" + list[i].getJarak(j) + " m), ");
                }
                System.out.println();
            } 
        }
        System.out.println();
    }

    public void cekEdge(int asal, int tujuan) throws Exception {
        boolean cek = false;
        for(int i = 0; i < list[asal].size(); i++) {
            if(list[asal].get(i) == tujuan) {
                cek = true;
            }
        }
        if(cek == true) {
            System.out.println("Gedung " + (char) ('A' + asal) + " dan " + (char) ('A' + tujuan) + " bertetangga");
        } else {
            System.out.println("Gedung " + (char) ('A' + asal) + " dan " + (char) ('A' + tujuan) + " tidak bertetangga");
        }
    }

    public void updateJarak(int asal, int tujuan, int jarakBaru) throws Exception {
        boolean cek = false;
        for(int i = 0; i < list[asal].size(); i++) {
            if(list[asal].get(i) == tujuan) {
                cek = true;
            }
        }
        if (cek == true) {
            list[asal].updateJarak(tujuan, jarakBaru);
            System.out.println("Jarak Gedung " + (char) ('A' + asal) + " dan " + (char) ('A' + tujuan) + " diperbarui menjadi " + jarakBaru + " m");
        } else {
            System.out.println("Gedung " + (char) ('A' + asal) + " dan " + (char) ('A' + tujuan) + " tidak bertetangga");
        }
    }

    public void hitungEdge() {
        int jml = 0;
        for (int i = 0; i < vertex; i++) {
            jml += list[i].size();
        }
        System.out.println("Jumlah Edge dari Graph: " + jml);
    }
}
