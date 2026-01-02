public class SickLeaveRequest extends LeaveRequest {

    private boolean medicalCertificateProvided;

    public SickLeaveRequest(int requestId, Employee employee,
                            String startDate, String endDate,
                            boolean medicalCertificateProvided) {
        super(requestId, employee, startDate, endDate,
              "Pending", "Sick Leave");
        this.medicalCertificateProvided = medicalCertificateProvided;
    }

    @Override
    public boolean approve(String approverName) {
        if (!medicalCertificateProvided && calculateLeaveDays() > 2) {
            System.out.println("Medical certificate required");
            return false;
        }
        changeStatus("Approved", approverName);
        return true;
    }

    @Override
    public boolean deny(String approverName, String reason) {
        changeStatus("Denied", approverName);
        return true;
    }

    @Override
    public int calculateLeaveDays() {
        return 3; // placeholder
    }
}
