package glacialExpedition.models.mission;

import glacialExpedition.models.explorers.Explorer;
import glacialExpedition.models.states.State;

import java.util.Collection;

public class MissionImpl implements Mission {
    public MissionImpl() {
    }

    @Override
    public void explore(State state, Collection<Explorer> explorers) {
        for (Explorer explorer : explorers) {
            if(explorer.getEnergy() < 0) {
                continue;
            }

            if(!state.getExhibits().isEmpty()) {
                while(state.getExhibits().iterator().hasNext()) {
                    if(explorer.getEnergy() == 0) {
                        break;
                    }

                    String currentExhibit = state.getExhibits().iterator().next();
                    explorer.search();
                    explorer.getSuitcase().getExhibits().add(currentExhibit);
                    state.getExhibits().remove(currentExhibit);
                }
            }
        }
    }
}
