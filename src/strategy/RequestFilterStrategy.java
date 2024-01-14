package strategy;

import context.BookRequestManager;

public interface RequestFilterStrategy {
    void filterAndPrintRequests(BookRequestManager manager);
}
