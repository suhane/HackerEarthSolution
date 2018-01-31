package swiggy.interviewPrep;

import org.junit.BeforeClass;
import org.junit.Test;

import java.io.*;
import java.util.Arrays;

public class ExternalSort {

    static String input_file = "input.txt";
    static String output_file = "output.txt";
    static int num_Temp_OutputStreams = 10;
    static int run_size = 100000;

    class MinHeapNode{
        int element;
        int arrayIndex;

        public MinHeapNode(int element, int arrayIndex) {
            this.element = element;
            this.arrayIndex = arrayIndex;
        }
    }

    class MinHeap{

        MinHeapNode[] harr;
        int hsize;

        public MinHeap(MinHeapNode[] harr) {

            this.harr = harr;
            this.hsize=harr.length;

            for(int i=hsize/2;i>=0;i--){
                minHeapify(i);
            }

        }

        public MinHeapNode getMin(){
            return harr[0];
        }


        private int left(int i){return  2*i+1;};
        private int right(int i){return 2*i+2;};

        private void minHeapify(int i){
            int smallest=i;
            int left=left(i);
            int right=right(i);

            if(left<hsize && harr[left].element<harr[smallest].element)
                smallest=left;
            if(right<hsize && harr[right].element<harr[smallest].element)
                smallest=right;
            if(i!=smallest){
               MinHeapNode temp=harr[smallest];
               harr[smallest]=harr[i];
               harr[i]=temp;
               minHeapify(smallest);
            }
        }

        public void replaceMin(MinHeapNode root) {
            {
                harr[0] = root;
                minHeapify(0);
            }
        }
    }


    @BeforeClass
    public static void setUp(){

        PrintWriter out=null;
        try {
            out= new PrintWriter(input_file);
            for (int i = 0; i < num_Temp_OutputStreams * run_size; i++)
                out.println( (int)(Math. random() * 50 + 1));
            out.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    //@Test
    public void createInitialRuns(){


        //creating temp output streams

        PrintWriter[] out= new PrintWriter[num_Temp_OutputStreams];
        for (int i = 0; i < num_Temp_OutputStreams; i++)
        {
            try {
                out[i] = new PrintWriter(output_file+i);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

        int[] arr= new int[run_size];
        boolean more_input = true;
        int next_output_file = 0;
        int i;
        BufferedReader br=null;
        try {

            br = new BufferedReader(new FileReader(input_file));
            String line;

            while (more_input) {
                i = 0;
                while (i < run_size) {

                    if((line = br.readLine()) != null)
                        arr[i++] = Integer.parseInt(line);
                    else{
                        more_input=false;
                        break;
                    }
                }
                Arrays.sort(arr);
                for (int j = 0; j < i; j++)
                    out[next_output_file].println(arr[j]);
                next_output_file++;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (i = 0; i < num_Temp_OutputStreams; i++)
            out[i].close();
    }

    //@Test
    public void mergeFiles(){

        BufferedReader[] br=new BufferedReader[num_Temp_OutputStreams];
        for(int i = 0; i< num_Temp_OutputStreams; i++){
            try {
                br[i]=new BufferedReader(new FileReader(output_file+i));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        PrintWriter finalOutputFile = null;
        try {
            finalOutputFile=new PrintWriter(output_file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        MinHeapNode[] arr= new MinHeapNode[num_Temp_OutputStreams];
        for(int i = 0; i< num_Temp_OutputStreams; i++){
            String line;
            try {
                if((line=br[i].readLine())!=null){
                    arr[i]=new MinHeapNode(Integer.parseInt(line),i);
                }
                else
                    break;
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        MinHeap minHeap= new MinHeap(arr);
        for (int count = 0; count < num_Temp_OutputStreams *run_size; count++) {

            MinHeapNode root= minHeap.getMin();
            finalOutputFile.println(root.element);
            String line;
            try {
                if((line=br[root.arrayIndex].readLine())!=null){
                    root.element=Integer.parseInt(line);
                }
                else
                    root.element=Integer.MAX_VALUE;
            } catch (IOException e) {
                e.printStackTrace();
            }

            minHeap.replaceMin(root);

        }


        finalOutputFile.close();

    }

    @Test
    public void testExternalSort(){
        createInitialRuns();
        mergeFiles();
    }



}
