
import util.Hash;

import java.util.ArrayList;


public class main {
    public static void main(String[] args) {

        //Initialize a database
        int data_size = 10;
        int ELEMENT_SIZE= (int) Math.pow(2, data_size);//size of all elements
        int DEFAULT_INITIAL_CAPACITY = (int) Math.floor((ELEMENT_SIZE * (1 + 0.3)));//size of each table.(two table store all elements)
        long[] table = new long[ELEMENT_SIZE];
        for (int i = 0; i < ELEMENT_SIZE; i++) {
            table[i]=i;
        }


        //Construct a cuckoo hash table
        cuckoo cuckoo = new cuckoo();
        long[] cuckoo_EMM = cuckoo.setup(table,data_size);
        ArrayList<Integer> cuckoo_Stash = cuckoo.Get_Cuckoo_Stash();
        for(int i=0;i<cuckoo_Stash.size();i++){
            System.out.println("Stash:"+cuckoo_Stash.get(i));
        }
        System.out.println("Stash Size:"+cuckoo_Stash.size());


        //Query
        int keyword = 984;//search keyword
        int t_0 =  Hash.reduce((int) Hash.hash64(keyword,0),DEFAULT_INITIAL_CAPACITY);//first possible position
        int t_1 =  Hash.reduce((int) Hash.hash64(keyword,1),DEFAULT_INITIAL_CAPACITY)+DEFAULT_INITIAL_CAPACITY;//second possible position
        String res = cuckoo_EMM[t_0]+" "+cuckoo_EMM[t_1];
        System.out.println(res);

    }
}
