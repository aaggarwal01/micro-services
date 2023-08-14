package net.nrb.ExceptionalHandler;


public class RecordNotFoundException extends Exception {

    public RecordNotFoundException() {
        super();
        // TODO Auto-generated constructor stub
    }

    public RecordNotFoundException(Integer no) {
        super("Course Does not exit");

    }

}
