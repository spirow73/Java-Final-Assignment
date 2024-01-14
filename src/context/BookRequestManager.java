package context;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BookRequestManager {
    private List<BookRequestContext> requests = new ArrayList<>();

    public void addRequest(BookRequestContext request) {
        requests.add(request);
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

    //
    

    // Métodos para obtener solicitudes en otros estados, si es necesario
}