import java.util.ArrayList;

public abstract class LeaveRequest implements Approvable {

    protected int requestId;
    protected Employee employee;
    protected String startDate;
    protected String endDate;
    protected String status;
    protected String reason;

    private ArrayList<StatusChange> statusHistory = new ArrayList<>();

    public LeaveRequest(int requestId, Employee employee,
                        String startDate, String endDate,
                        String status, String reason) {
        this.requestId = requestId;
        this.employee = employee;
        this.startDate = startDate;
        this.endDate = endDate;
        this.status = status;
        this.reason = reason;
    }

    public int getRequestId() {
        return requestId;
    }

    public Employee getEmployee() {
        return employee;
    }

    public String getStatus() {
        return status;
    }

    public void changeStatus(String newStatus, String changedBy) {
        StatusChange change =
            new StatusChange(this.status, newStatus, "TODAY", changedBy);
        statusHistory.add(change);
        this.status = newStatus;
    }

    public abstract int calculateLeaveDays();

    class StatusChange {
        String oldStatus;
        String newStatus;
        String changeDate;
        String changedBy;

        StatusChange(String oldStatus, String newStatus,
                     String changeDate, String changedBy) {
            this.oldStatus = oldStatus;
            this.newStatus = newStatus;
            this.changeDate = changeDate;
            this.changedBy = changedBy;
        }
    }
}
