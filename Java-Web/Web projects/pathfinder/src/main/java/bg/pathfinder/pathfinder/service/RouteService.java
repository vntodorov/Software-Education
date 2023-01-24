package bg.pathfinder.pathfinder.service;

import bg.pathfinder.pathfinder.model.Route;
import bg.pathfinder.pathfinder.repository.RouteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RouteService {

    private final RouteRepository routeRepository;

    @Autowired
    public RouteService(RouteRepository routeRepository) {
        this.routeRepository = routeRepository;
    }

    public Route getMostCommented(){
        return routeRepository.findMostCommented();
    }

}
