package org.vaadin.demo.presenter.json;

import org.springframework.stereotype.Component;
import org.vaadin.demo.view.json.JsonView;
import org.vaadin.mvp.base.presenter.BasePresenter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.stream.Collectors;

@Component
public abstract class JsonPresenter<V extends JsonView> extends BasePresenter<V>{

    final static String PRESENTER_NAME = "jsonPresenter";

    public JsonPresenter(V view) {
        super(view);
    }

    @Override
    protected void init() {
        populateDate();
        populateGridData();
    }

    private void populateDate() {
        final String json = "[ " +
                "{   \"name\" : \"1 value\",   \"id\" : 1   }, " +
                "{   \"name\" : \"2 Value\",   \"id\" : 2   }, " +
                "{   \"name\" : \"3 Value\",   \"id\" : 3   }, " +
                "{   \"name\" : \"4 Value\",   \"id\" : 4   }, " +
                "{   \"name\" : \"5 Value\",   \"id\" : 5   }  " +
                "]";

        getView().populateComboBoxData(json);
    }

    private void populateGridData() {
        getView().updateLoading();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        URL url = null;
        try {
            url = new URL("https://api.github.com/users/mralexgray/repos");
            final HttpURLConnection con = (HttpURLConnection) url.openConnection();

            final BufferedReader br;
            if (con.getResponseCode() >= 400 ) {
                br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
            } else {
                br = new BufferedReader(new InputStreamReader(con.getInputStream()));
            }


            String mess = br.lines().collect(Collectors.joining());

            getView().populateGridData(mess);


        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (ProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
