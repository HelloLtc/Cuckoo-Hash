import util.Hash;

import java.util.ArrayList;

public class cuckoo {

    public cuckoo(){}
    static ArrayList<Integer> cuckoo_Stash =  new ArrayList<Integer>();

    long[] setup(long[] table,int data_size){
        int ELEMENT_SIZE = (int) Math.pow(2, data_size);
        int DEFAULT_INITIAL_CAPACITY = (int) Math.floor((ELEMENT_SIZE * (1 + 0.3)));
        long[] table_cuckoo = new long[DEFAULT_INITIAL_CAPACITY*2];
        for (int i = 0; i < ELEMENT_SIZE; i++) {
            cuckoo.insertEntry(table_cuckoo,table[i],data_size,DEFAULT_INITIAL_CAPACITY);
        }
        return table_cuckoo;
    }

    static void insertEntry(long[] table,long key,int datasize,int DEFAULT_INITIAL_CAPACITY) {
        int count = 0;
        int h =0;
        while (count < 5*datasize) {
            h = Hash.reduce((int) Hash.hash64(key,0),DEFAULT_INITIAL_CAPACITY);
            long temp = table[h];
            if (temp == 0) {
                table[h] = key;
                return;
            } else {
                table[h] = key;
                key = temp;
            }

            h = Hash.reduce((int) Hash.hash64(key,1),DEFAULT_INITIAL_CAPACITY)+DEFAULT_INITIAL_CAPACITY;
            temp = table[h];
            if (temp == 0) {
                table[h] = key;
                return;
            } else {
                table[h] = key;
                key = temp;
            }
            count++;
        }
        if(count>=5*datasize)
        {
            cuckoo_Stash.add((int) key);
        }
    }

    public ArrayList<Integer> Get_Cuckoo_Stash(){
        return cuckoo_Stash;
    }
}

