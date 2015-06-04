/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package main;

import java.io.*;
import javax.microedition.rms.*;

/**
 *
 * @author pabiagioli
 */
public class DBHorario {
    

    private RecordStore recordStore = null;
   
    public DBHorario() {}

    public RecordStore getRecordStore() {
        return recordStore;
    }
    // Open a record store with the given name
    public DBHorario(String fileName) {
      try {
        recordStore = RecordStore.openRecordStore(fileName, true);
        } catch(RecordStoreException rse) {
            rse.printStackTrace();
        }
    }

    // Close the record store
    public void close() throws RecordStoreNotOpenException, RecordStoreException {
        if (recordStore.getNumRecords() == 0) {
            String fileName = recordStore.getName();
            recordStore.closeRecordStore();
            recordStore.deleteRecordStore(fileName);
        } else {
            recordStore.closeRecordStore();
        }
    }

   // Add a new record (stock) 
   // to the record store
   public synchronized void addNewHora(String record) {
	ByteArrayOutputStream baos = new ByteArrayOutputStream();
	DataOutputStream outputStream = new DataOutputStream(baos);
	try {
	    outputStream.writeUTF(record);
	}
	catch (IOException ioe) {
	    System.out.println(ioe);
	    ioe.printStackTrace();
	}
	byte[] b = baos.toByteArray();
	try {
	    recordStore.addRecord(b, 0, b.length);
	}
	catch (RecordStoreException rse) {
	    System.out.println(rse);
	    rse.printStackTrace();
	}
    }

    // Enumerate through the records.
    public synchronized RecordEnumeration enumerate() throws RecordStoreNotOpenException {
       return recordStore.enumerateRecords(null, null, false);
    }

}
