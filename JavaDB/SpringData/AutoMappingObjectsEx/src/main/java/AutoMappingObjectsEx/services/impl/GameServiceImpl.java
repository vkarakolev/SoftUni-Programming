package AutoMappingObjectsEx.services.impl;

import AutoMappingObjectsEx.entities.games.AddDTO;
import AutoMappingObjectsEx.entities.games.EditDTO;
import AutoMappingObjectsEx.entities.games.Game;
import AutoMappingObjectsEx.services.GameService;
import org.springframework.stereotype.Service;

@Service
public class GameServiceImpl implements GameService {
    @Override
    public Game add(AddDTO addData) {
        return null;
    }

    @Override
    public Game edit(EditDTO editData) {
        return null;
    }

    @Override
    public Game delete(int id) {
        return null;
    }
}
