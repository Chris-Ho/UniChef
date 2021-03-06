package com.example.unichef.database;

import java.io.Serializable;
import java.util.ArrayList;

public class Recipe implements Serializable {
    private long id;
    private User user;
    private String title;
    private String description;
    private byte[] image;
    private long dateAdded;
    private ArrayList<Instruction> instructions;
    private ArrayList<Ingredient> ingredients;
    private ArrayList<Equipment> equipment;
    private ArrayList<Tag> tags;
    private int likes;
    private int difficulty;
    private int time;
    private int portions;
    private ArrayList<Comment> comments;

    public Recipe(){}

    public Recipe(User user, String title, String description, byte[] image, long dateAdded, ArrayList<Instruction> instructions, ArrayList<Ingredient> ingredients, ArrayList<Equipment> equipment, ArrayList<Tag> tags, int likes, int difficulty, int time, int portions) {
        this.user = user;
        this.title = title;
        this.description = description;
        this.image = image;
        this.dateAdded = dateAdded;
        this.instructions = instructions;
        this.ingredients = ingredients;
        this.equipment = equipment;
        this.tags = tags;
        this.likes = likes;
        this.difficulty = difficulty;
        this.time = time;
        this.portions = portions;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] imageUrl) {
        this.image = imageUrl;
    }

    public long getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(long dateAdded) {
        this.dateAdded = dateAdded;
    }

    public ArrayList<Instruction> getInstructions() {
        return instructions;
    }

    public void setInstructions(ArrayList<Instruction> instructions) {
        this.instructions = instructions;
    }

    public void addInstruction(Instruction instruction){
        instructions.add(instruction);
    }

    public ArrayList<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(ArrayList<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public void addIngredient(Ingredient ingredient){
        ingredients.add(ingredient);
    }

    public ArrayList<Equipment> getEquipment() {
        return equipment;
    }

    public void setEquipment(ArrayList<Equipment> equipment) {
        this.equipment = equipment;
    }

    public void addEquipment(Equipment e){
        equipment.add(e);
    }

    public ArrayList<Tag> getTags() {
        return tags;
    }

    public void setTags(ArrayList<Tag> tags) {
        this.tags = tags;
    }

    public void addTag(Tag tag){
        tags.add(tag);
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public int getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public int getPortions() {
        return portions;
    }

    public void setPortions(int portions) {
        this.portions = portions;
    }

    public ArrayList<Comment> getComments(){
        return comments;
    }

    public void setComments(ArrayList<Comment> comments) {
        this.comments = comments;
    }

    public void addComment(Comment comment){
        comments.add(comment);
    }
}
