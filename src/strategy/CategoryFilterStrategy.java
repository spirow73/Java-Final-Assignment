package strategy;

import context.BookRequestManager;

public class CategoryFilterStrategy implements RequestFilterStrategy {
    private String category;

    public CategoryFilterStrategy(String category) {
        this.category = category;
    }

    @Override
    public void filterAndPrintRequests(BookRequestManager manager) {
        System.out.println("Requests for category: " + category);
        manager.getRequests().stream()
                .filter(request -> request.getBook().getCategory().equals(category))
                .forEach(request -> System.out.println(request.getBook().getTitle()));
    }
}
