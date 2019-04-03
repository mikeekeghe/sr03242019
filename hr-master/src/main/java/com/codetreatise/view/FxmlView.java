package com.codetreatise.view;

import java.util.ResourceBundle;

public enum FxmlView {

    SUDOKU {
        @Override
        public String getTitle() {
            return getStringFromResourceBundle("sudoku.title");
        }

        @Override
        public String getFxmlFile() {
            return "/fxml/Sudoku.fxml";
        }
    },
    LOGIN {
        @Override
        public String getTitle() {
            return getStringFromResourceBundle("login.title");
        }

        @Override
        public String getFxmlFile() {
            return "/fxml/Login.fxml";
        }
    },
    ITEM_MASTER {
        @Override
        public String getTitle() {
            return getStringFromResourceBundle("itemMaster.title");
        }

        @Override
        public String getFxmlFile() {
            return "/fxml/Master.fxml";
        }
    },
    ITEM_LISTING {
        @Override
        public String getTitle() {
            return getStringFromResourceBundle("itemListing.title");
        }

        @Override
        public String getFxmlFile() {
            return "/fxml/Items.fxml";
        }
    },
    APP {
        @Override
        public String getTitle() {
            return getStringFromResourceBundle("app.title");
        }

        @Override
        public String getFxmlFile() {
            return "/fxml/App.fxml";
        }
    };
    
    public abstract String getTitle();
    public abstract String getFxmlFile();
    
    String getStringFromResourceBundle(String key){
        return ResourceBundle.getBundle("Bundle").getString(key);
    }

}
