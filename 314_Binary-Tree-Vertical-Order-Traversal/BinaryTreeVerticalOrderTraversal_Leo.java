class GfG
{
    void verticalOrder(Node node) 
    {
        Integer min = 0;
        Integer max = 0;
        HashMap<Integer, LinkedList<Integer>> map = new HashMap<>();
        LinkedList<Node> queue = new LinkedList<>();
        LinkedList<Integer> layer = new LinkedList<>();
        queue.add(node);
        layer.add(0);
        while (!queue.isEmpty()) {
          Node n = queue.removeFirst();
          Integer current = layer.removeFirst();
          if (current < min) {
            min = current;
          } else if (current > max) {
            max = current;
          }
          LinkedList<Integer> list = map.get(current);
          if (null == list) {
            list = new LinkedList<>();
            map.put(current, list);
          }
          list.add(n.data);
          
          if (n.left != null) {
            queue.add(n.left);
            layer.add(current-1);
          }
          if (n.right != null) {
            queue.add(n.right);
            layer.add(current+1);
          }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = min; i<=max; i++) {
          LinkedList<Integer> list = map.get(i);
          for (Integer v:list) {
            sb.append(v).append(' ');
          }
          sb.append('$');
        }
        System.out.print(sb.toString());
    }
}
