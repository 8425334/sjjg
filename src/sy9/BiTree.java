package sy9;

import java.util.BitSet;

public class BiTree {
    Node root;

    public BiTree(){
        this.root = new Node();
    }

    public BiTree(Node root){
        this.root = root;
    }


    public Node searchNode(Node root, Object x){
        if (root != null){
            //判断值是否相等
            if (String.valueOf(root.data).equals(x)){
                return root;
            }
            //查找左子树
            Node l = searchNode(root.lChild, x);
            //左子树为空就找右子树
            if (l == null){
                return searchNode(root.rChild, x);
            }
        }
        return null;
    }

    public BiTree createByPreAndMid(String pre, String mid){
        //判断序列的合法性
        if (mid.length() != pre.length()){
            throw new IllegalArgumentException("序列长度不合法");
        }
        return createByPreAndMid(this.root, pre, mid);
    }

    public BiTree createByMidAndEnd(String pre, String mid){
        //判断序列的合法性
        if (mid.length() != pre.length()){
            throw new IllegalArgumentException("序列长度不合法");
        }
        return createByMidAndEnd(this.root, pre, mid);
    }

    /**
     * 分治法(GDHBAECIF GHDBEIFCA为例)
     * 通过中序和后序序列创建二叉树
     */
    public BiTree createByMidAndEnd(Node root, String mid, String end){
        //程序入口,当序列长度不不止一个字符的时候依次遍历(前序和后序的长度应当相等)
        if (mid.length() >= 1){
            //获取后序序列中的根节点在中序序列中的索引
            int index = mid.indexOf(end.charAt(end.length() - 1));
            //赋值
            root.data = end.charAt(end.length() - 1);
            //创建左子树(GDHB GHDB)
            root.lChild = new Node();
            createByMidAndEnd(root.lChild, mid.substring(0, index), end.substring(0, index));
            //创建右子树(EIFC ECIF)
            root.rChild = new Node();
            createByMidAndEnd(root.rChild, mid.substring(index + 1), end.substring(index, end.length() - 1));
        }
        return this;
    }

    /**
     * 分治法(ABDGHCEFI GDHBAECIF为例)
     * 通过前根和中根序列创建二叉树
     */
    public BiTree createByPreAndMid(Node root, String pre, String mid){
        //程序入口,当序列长度不不止一个字符的时候依次遍历(前序和后序的长度应当相等)
        if (pre.length() >= 1){
            //获取前序序列中的根节点在中序序列中的索引
            int index = mid.indexOf(pre.charAt(0));
            root.data = pre.charAt(0);
            //创建左子树(BDGH GDHB)
            root.lChild = new Node();
            createByPreAndMid(root.lChild, pre.substring(1, index + 1), mid.substring(0, index));
            //创建右子树(CEFI ECIF)
            root.rChild = new Node();
            createByPreAndMid(root.rChild, pre.substring(index + 1), mid.substring(index + 1));
        }
        return this;
    }
    /**
     * 前序遍历
     */
    public String preErgodic(){
        return ergodic(0, this.root);
    }

    /**
     * 中序遍历
     */
    String midErgodic(){
        return ergodic(1, this.root);
    }

    /**
     * 后序遍历
     */
    String endErgodic(){
        return ergodic(2, this.root);
    }

    /**
     * 二叉树遍历主代码
     */
    private String ergodic(int ergodic, Node node){
        if (node != null){
            if (node.data != null){
                //前序遍历
                if (ergodic == 0){
                    return node.data + ergodic(0, node.lChild) + ergodic(0, node.rChild);
                }
                //中序遍历
                if (ergodic == 1){
                    return ergodic(1, node.lChild) + node.data + ergodic(1, node.rChild);
                }
                //后序遍历
                if (ergodic == 2){
                    return ergodic(2, node.lChild) + ergodic(2, node.rChild)+ node.data ;
                }
                return null;
            }
            return ergodic(0, node.lChild) + ergodic(0, node.rChild);
        }
        return "";
    }


    /**
     * 求结点数
     */
    int countNode(Node root){
        if (root != null){
            //左右子节点为空时返回0不做累加
            if (root.lChild == null || root.rChild == null){
                return 0;
            }
            //累加递归操作
            return 1 + countNode(root.lChild) + countNode(root.rChild);
        }
        return 0;
    }

    /**
     * 求节点深度(分治思想)
     */
    int getDepth(Node root){
        if (root != null) {
            //当节点为叶子节点时,不再进行深度探测
            if (root.lChild == null || root.rChild == null){
                return 0;
            }
            //分别遍历左子树和右子树,只要当前节点不是叶子节点, 深度都+1
            int l = getDepth(root.lChild) + 1;
            int r = getDepth(root.rChild) + 1;
            //递归出口,判断左子树和右子树的深度,取最大值
            return Math.max(l, r);
        }
        return 0;
    }
}
