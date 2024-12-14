package emp;

class EmployeeIdAlreadyExistsException extends Exception {
	static final long serialVersionUID = 1L;
    public EmployeeIdAlreadyExistsException(String s) {
        super(s);
    }
}
