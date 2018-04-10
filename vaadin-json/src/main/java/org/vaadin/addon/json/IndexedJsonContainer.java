package org.vaadin.addon.json;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vaadin.data.Item;
import com.vaadin.data.util.IndexedContainer;

import java.util.Iterator;
import java.util.Map;
import java.util.function.Consumer;

public class IndexedJsonContainer extends IndexedContainer implements JsonContainer{

    public IndexedJsonContainer(String json) {
        super();
        final JsonNode node = populateNodeFromJsonString(json);
        initFromNode(node);
    }

    public IndexedJsonContainer(JsonNode node) {
        super();
        initFromNode(node);
    }

    private void initFromNode(JsonNode node) {
        if (node != null) {
            switch (node.getNodeType()) {
                case OBJECT:
                    addJsonObject(node);
                    break;
                case ARRAY:
                    addJsonArray(node);
                    break;
            }
        }
    }

    private void addJsonArray(JsonNode node) {
        node.forEach(new Consumer<JsonNode>() {
            @Override
            public void accept(JsonNode jsonNode) {
                switch (jsonNode.getNodeType()) {
                    case OBJECT:
                        addJsonObject(jsonNode);
                        break;
                }
            }
        });
    }


    private JsonNode populateNodeFromJsonString(String content) {
        final ObjectMapper mapper = new ObjectMapper();
        try {
            final JsonFactory factory = mapper.getFactory();
            final JsonParser parser = factory.createParser(content);
            final JsonNode rootNode = mapper.readTree(parser);
            return rootNode;

        } catch (Exception e) {

        }

        return null;
    }

    private void addJsonObject(JsonNode jsonObject) {
        // use itemId generated by IndexedContainer
        final Object itemId = addItem();
        final Item i = getItem(itemId);

        final Iterator<Map.Entry<String, JsonNode>> iterator = jsonObject.fields();

        while (iterator.hasNext()) {
            final Map.Entry<String, JsonNode> entry = iterator.next();
            addContainerProperty(entry.getKey(), String.class, null);
            i.getItemProperty(entry.getKey()).setValue(
                    entry.getValue().asText());
        }
    }
}
