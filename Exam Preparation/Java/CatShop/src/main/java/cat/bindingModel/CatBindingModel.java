package cat.bindingModel;

import javax.validation.constraints.NotNull;

public class CatBindingModel {
    @NotNull
    private String name;
    @NotNull
    private String nickname;
    @NotNull
    private Double price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
