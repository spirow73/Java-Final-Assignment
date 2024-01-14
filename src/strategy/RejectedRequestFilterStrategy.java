package strategy;

import context.*;

public class RejectedRequestFilterStrategy implements RequestFilterStrategy {
    @Override
    public void filterAndPrintRequests(BookRequestManager manager) {
        System.out.println("Rejected requests:");
        manager.printRequestsByState(RejectedState.class);
    }
}