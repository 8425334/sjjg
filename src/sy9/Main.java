package sy9;

public class Main {
    public static void main(String[] args) {
        t2();
    }
    private static void t1(){
        String pre = "ABDGHCEFI";
        String mid = "GDHBAECIF";
        BiTree biTree = new BiTree()
                .createByPreAndMid(pre, mid);

        System.out.println("后序序列:" + biTree.endErgodic());
        Node node = biTree.searchNode(biTree.root, "C");
        System.out.println("地址:" + node.hashCode() + ", data:" + node.data);
        System.out.println("结点数量:" + biTree.countNode(biTree.root));
        System.out.println("结点深度:" + biTree.getDepth(biTree.root));
    }

    private static void t2(){
        String mid = "ABCDEFGHI";
        String end = "ACDBGIHFE";
        BiTree tree = new BiTree()
                .createByMidAndEnd(mid, end);
        System.out.println("先序序列:" + tree.preErgodic());
    }
}
