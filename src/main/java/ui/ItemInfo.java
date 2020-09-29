package ui;

public class ItemInfo {
    private String name;
    private String description;

    public ItemInfo(String name, String description){
        this.name = name;
        this.description = description;
    }

    public String getDescription(){
        return description;
    }

    public void setDescription(String newDesc){
        this.description = newDesc;
    }

    public String getName(){
        return name;
    }

    public void setName(String newName){
        this.name = newName;
    }
}
