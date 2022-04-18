package shataj.durbar.rrrrrr;

import java.util.List;

public class main {
    List<childitem> postList;
String currentDynamicKey;

    public String getCurrentDynamicKey() {
        return currentDynamicKey;
    }

    public void setCurrentDynamicKey(String currentDynamicKey) {
        this.currentDynamicKey = currentDynamicKey;
    }

    public main() {

    }


    public main(List<childitem> postList, String currentDynamicKey) {
        this.postList = postList;
      //  this.currentDynamicKey = currentDynamicKey;
    }


    public main(String currentDynamicKey) {
    }


    public List<childitem> getPostList() {
        return postList;
    }

    public void setPostList(List<childitem> postList) {
        this.postList = postList;

    }

}
