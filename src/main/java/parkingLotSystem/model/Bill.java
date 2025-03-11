package parkingLotSystem.model;

import java.util.Date;
import java.util.List;

public class Bill extends  BaseModel{
    private Integer BillNo;
    private List<Payment> Payment;
    private double Amount;
    private Ticket ticket;
    private Date exitTime;
    private Operator operator;
    private PaymentStatus paymentStatus;

    public Integer getBillNo() {
        return BillNo;
    }

    public void setBillNo(Integer billNo) {
        BillNo = billNo;
    }

    public List<Payment> getPayment() {
        return Payment;
    }

    public void setPayment(List<Payment> payment) {
        Payment = payment;
    }

    public double getAmount() {
        return Amount;
    }

    public void setAmount(double amount) {
        Amount = amount;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public Date getExitTime() {
        return exitTime;
    }

    public void setExitTime(Date exitTime) {
        this.exitTime = exitTime;
    }

    public Operator getOperator() {
        return operator;
    }

    public void setOperator(Operator operator) {
        this.operator = operator;
    }

    public PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(PaymentStatus paymentStatus) {
        this.paymentStatus = paymentStatus;
    }
}
