package context;

import java.util.ArrayList;
import java.util.List;
import strategy.RequestFilterStrategy;
import java.util.stream.Collectors;

public class BookRequestManager {
    private static BookRequestManager instance;
    private List<BookRequestContext> requests;
    private RequestFilterStrategy filterStrategy;

    private BookRequestManager() {
        requests = new ArrayList<>();
    }

    public static synchronized BookRequestManager getInstance() {
        if (instance == null) {
            instance = new BookRequestManager();
        }
        return instance;
    }

    public void setFilterStrategy(RequestFilterStrategy filterStrategy) {
        this.filterStrategy = filterStrategy;
    }

    public void applyFilterAndPrint() {
        if (filterStrategy != null) {
            filterStrategy.filterAndPrintRequests(this);
        } else {
            System.out.println("No filter strategy set.");
        }
    }

    public void addRequest(BookRequestContext request) {
        requests.add(request);
    }

    public List<BookRequestContext> getRequests() {
        return new ArrayList<>(requests);
    }

    public List<BookRequestContext> getRequestsByState(Class<? extends BookRequestState> stateClass) {
        return requests.stream()
                .filter(request -> stateClass.isInstance(request.getState()))
                .collect(Collectors.toList());
    }

    public void printRequestsByState(Class<? extends BookRequestState> stateClass) {
        List<BookRequestContext> requestsByState = getRequestsByState(stateClass);
        if (requestsByState.isEmpty()) {
            System.out.println("No hay solicitudes en el estado: " + stateClass.getSimpleName());
        } else {
            System.out.println("Solicitudes en el estado: " + stateClass.getSimpleName() + ":");
            for (BookRequestContext request : requestsByState) {
                System.out.println(request.getRequestDetails());
            }
        }
    }

    // Aquí puedes añadir más métodos según sea necesario
}
