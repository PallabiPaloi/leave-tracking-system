import java.util.ArrayList;

public class Employee {
    private int employeeId;
    private String name;
    private String department;
    private String email;
    private int leaveBalance = 20;

    private ArrayList<LeaveRequest> leaveHistory = new ArrayList<>();

    public Employee(int employeeId, String name, String department, String email) {
        this.employeeId = employeeId;
        this.name = name;
        this.department = department;
        this.email = email;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public String getDepartment() {
        return department;
    }

    public int getLeaveBalance() {
        return leaveBalance;
    }

    public void setLeaveBalance(int leaveBalance) {
        if (leaveBalance >= 0) {
            this.leaveBalance = leaveBalance;
        } else {
            System.out.println("Leave balance cannot be negative");
        }
    }

    public void addLeaveRequest(LeaveRequest request) {
        leaveHistory.add(request);
    }

    public ArrayList<LeaveRequest> getLeaveHistory() {
        return leaveHistory;
    }
}
