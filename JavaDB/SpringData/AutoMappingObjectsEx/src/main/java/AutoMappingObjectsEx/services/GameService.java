package AutoMappingObjectsEx.services;

import AutoMappingObjectsEx.entities.games.AddDTO;
import AutoMappingObjectsEx.entities.games.EditDTO;
import AutoMappingObjectsEx.entities.games.Game;

public interface GameService {
    Game add(AddDTO addData);
    Game edit(EditDTO editData);
    Game delete(int id);
}
