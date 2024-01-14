package strategy;

import context.*;

public class ApprovedRequestFilterStrategy implements RequestFilterStrategy {
    @Override
    public void filterAndPrintRequests(BookRequestManager manager) {
        System.out.println("Approved requests:");
        manager.printRequestsByState(ApprovedState.class);
    }
}
