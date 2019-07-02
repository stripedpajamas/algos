package algos;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;

public class TreeSerializer<T extends Comparable<T>> {
    private final ObjectMapper objectMapper = new ObjectMapper();

    public String serialize(final BinaryTree<T> tree) throws JsonProcessingException {
        return objectMapper.writeValueAsString(createValuesList(tree));
    }

    public BinaryTree<T> deserialize(final String string) throws IOException {
        final CollectionType collectionType = objectMapper.getTypeFactory().constructCollectionType(List.class, Object.class);
        final List<T> valuesList = objectMapper.readValue(string, collectionType);
        return fromValuesList(valuesList);
    }

    public List<T> createValuesList(final BinaryTree<T> tree) {
        final List<T> output = new ArrayList<>();
        final Queue<TreeNode<T>> queue = new LinkedList<>();
        queue.add(tree.treeRoot);
        while (!queue.isEmpty()) {
            final TreeNode<T> current = queue.poll();
            if (current != null) {
                output.add(current.val);
                queue.add(current.left);
                queue.add(current.right);
            } else {
                output.add(null);
            }
        }
        return output;
    }

    BinaryTree<T> fromValuesList(final List<T> valuesList) {
        final Queue<TreeNode<T>> parentQueue = new LinkedList<>();
        TreeNode<T> finalParent = null;
        TreeNode<T> currentParent = null;
        int currentIdx = 0;

        while (currentIdx < valuesList.size()) {
            final T currentVal = valuesList.get(currentIdx);
            if (currentParent == null) {
                if (currentVal == null)
                    break;
                currentParent = new TreeNode<>(currentVal);
                finalParent = currentParent;
            } else {
                currentParent = parentQueue.poll();
            }

            if (++currentIdx < valuesList.size()) {
                final T leftVal = valuesList.get(currentIdx);
                if (leftVal != null) {
                    currentParent.left = new TreeNode<>(leftVal);
                    parentQueue.add(currentParent.left);
                }
            }

            if (++currentIdx < valuesList.size()) {
                final T rightVal = valuesList.get(currentIdx);
                if (rightVal != null) {
                    currentParent.right = new TreeNode<>(rightVal);
                    parentQueue.add(currentParent.right);
                }
            }
        }

        return new BinaryTree<>(finalParent);
    }
}