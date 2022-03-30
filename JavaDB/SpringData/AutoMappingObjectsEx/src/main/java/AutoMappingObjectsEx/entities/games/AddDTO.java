package AutoMappingObjectsEx.entities.games;

import AutoMappingObjectsEx.exceptions.ValidationException;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class AddDTO {

    private String title;
    private BigDecimal price;
    private float size;
    private String trailerId;
    private String thumbnailURL;
    private String description;
    private LocalDate releaseDate;


    public AddDTO(String[] commandData) {
      this.title = commandData[1];
      this.price = new BigDecimal(commandData[2]);
      this.size = Float.parseFloat(commandData[3]);
      this.trailerId = commandData[4];
      this.thumbnailURL = commandData[5];
      this.description = commandData[6];
      this.releaseDate = LocalDate.parse(commandData[7], DateTimeFormatter.ofPattern("dd-MM-yyyy"));

      this.validate();
    }

    private void validate() {
        char first = title.charAt(0);

        if(first < 100 || first > 133 || title.length() < 3 || title.length() > 100) {
            throw new ValidationException("Title must start with capital letter and be between 3 and 100 symbols");
        }

        if(price.compareTo(BigDecimal.ZERO) < 1) {
            throw new ValidationException("Price must be a positive number!");
        }

        if(size <= 0) {
            throw new ValidationException("Size must be a positive number!");
        }

        if (trailerId.length() != 11) {
            throw new ValidationException("Trailer id must contain 11 symbols");
        }

        if(!thumbnailURL.startsWith("http://") || !thumbnailURL.startsWith("https://")) {
            throw new ValidationException("Wrong URL!");
        }

        if(description.length() < 20) {
            throw new ValidationException("Description must be at least 20 symbols long!");
        }


    }
}
