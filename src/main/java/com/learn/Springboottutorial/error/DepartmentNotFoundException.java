package com.learn.Springboottutorial.error;

public class DepartmentNotFoundException extends Exception{

    public DepartmentNotFoundException() {
        super();
    }

    public DepartmentNotFoundException(String s) {
        super(s);
    }

    public DepartmentNotFoundException(String s, Throwable throwable) {
        super(s, throwable);
    }

    public DepartmentNotFoundException(Throwable throwable) {
        super(throwable);
    }

    protected DepartmentNotFoundException(String s, Throwable throwable, boolean b, boolean b1) {
        super(s, throwable, b, b1);
    }
}
