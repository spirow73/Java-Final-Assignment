package strategy;

import context.*;

public class PendingRequestFilterStrategy implements RequestFilterStrategy {
    @Override
    public void filterAndPrintRequests(BookRequestManager manager) {
        System.out.println("Pending Requests:");
        manager.printRequestsByState(PendingState.class);
    }
}