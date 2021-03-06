package algos;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;

public class BinaryTreeSerializer<T extends Comparable<T>, Node extends AbstractBinaryTreeNode<T, Node>> {
    private final ObjectMapper objectMapper = new ObjectMapper();
    private final BinaryTreeNodeFactory<T, Node> nodeFactory;

    public BinaryTreeSerializer(final BinaryTreeNodeFactory<T, Node> nodeFactory) {
		this.nodeFactory = nodeFactory;
	}

    public String serialize(final BinaryTree<T, Node> tree) throws JsonProcessingException {
        return objectMapper.writeValueAsString(createValuesList(tree));
    }

    public Node deserialize(final String string) throws IOException {
        final CollectionType collectionType = objectMapper.getTypeFactory().constructCollectionType(List.class, Object.class);
        final List<T> valuesList = objectMapper.readValue(string, collectionType);
        return fromValuesList(valuesList);
    }

    public List<T> createValuesList(final BinaryTree<T, Node> tree) {
        final List<T> output = new ArrayList<>();
        final Queue<Node> queue = new LinkedList<>();
        queue.add(tree.getRoot());
        while (!queue.isEmpty()) {
            final Node current = queue.poll();
            if (current != null) {
                output.add(current.getVal());
                queue.add(current.getLeft());
                queue.add(current.getRight());
            } else {
                output.add(null);
            }
        }
        return output;
    }

    Node fromValuesList(final List<T> valuesList) {
        final Queue<Node> parentQueue = new LinkedList<>();
        Node finalParent = null;
        Node currentParent = null;
        int currentIdx = 0;

        while (currentIdx < valuesList.size()) {
            final T currentVal = valuesList.get(currentIdx);
            if (currentParent == null) {
                if (currentVal == null) {
                    break;
                }
                currentParent = nodeFactory.fromValue(currentVal);
                finalParent = currentParent;
            } else {
                currentParent = parentQueue.poll();
            }

            if (++currentIdx < valuesList.size()) {
                final T leftVal = valuesList.get(currentIdx);
                if (leftVal != null) {
                    currentParent.setLeft(nodeFactory.fromValue(leftVal));
                    parentQueue.add(currentParent.getLeft());
                }
            }

            if (++currentIdx < valuesList.size()) {
                final T rightVal = valuesList.get(currentIdx);
                if (rightVal != null) {
                    currentParent.setRight(nodeFactory.fromValue(rightVal));
                    parentQueue.add(currentParent.getRight());
                }
            }
        }

        return finalParent;
    }
}