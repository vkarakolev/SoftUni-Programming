package harvestingFields;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		List<Field> fields = Arrays.asList(RichSoilLand.class.getDeclaredFields());
		Map<String, List<Field>> fieldsByModifier = createFieldsByModifierMap(fields);

		String command = scanner.nextLine();
		while (!command.equals("HARVEST")) {
			if(command.equals("all")) {
				fields.forEach(Main::printer);
			} else {
				fieldsByModifier.get(command).forEach(Main::printer);
			}

			command = scanner.nextLine();
		}
	}

	private static void printer(Field field) {
		System.out.printf("%s %s %s%n", Modifier.toString(field.getModifiers()),
				field.getType().getSimpleName(), field.getName());
	}

	private static Map<String, List<Field>> createFieldsByModifierMap(List<Field> fields) {
		Map<String, List<Field>> map = new LinkedHashMap<>();

		for (Field field : fields) {
			String modifier = Modifier.toString(field.getModifiers());
			map.putIfAbsent(modifier, new ArrayList<>());
			map.get(modifier).add(field);
		}

		return map;
	}
}
