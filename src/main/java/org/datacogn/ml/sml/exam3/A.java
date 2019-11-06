package org.datacogn.ml.sml.exam3;

import org.datacogn.ml.sml.base.BinaryTreeNode;

/**
 * User:krisjin
 * Date:2019-11-06
 */
public class A {


    /**
     * 依据给定的X和Y数据，基于最小二乘回归树生成 1 个二叉树（1个节点）
     * 选择最优的切分点
     * @param xdata
     * @param ydata
     * @return
     */
    BinaryTreeNode generateRegressTreeNode(double[] xdata, double[] ydata) {
        BinaryTreeNode brn = null;
        int dataLength = xdata.length;
        double minSum = 0;
        // 遍历输入值，将xdata分为2个部分
        for (int i = 0; i < dataLength; i++) {
            // X数据的每一个值都可作为切分点
            double splitPoint = xdata[i];

            int[] r1Idx = new int[dataLength];
            int[] r2Idx = new int[dataLength];

            for (int j = 0; j < dataLength; j++) {
                r1Idx[j] = -1;
                r2Idx[j] = -1;
                if (xdata[j] > splitPoint) {
                    r2Idx[j] = j;
                } else {
                    r1Idx[j] = j;
                }
            }
            // 切分点左侧Y的数据均值
            double c1 = meanMatrix1DByIdx(ydata, r1Idx);
            // 切分点右侧Y的数据均值
            double c2 = meanMatrix1DByIdx(ydata, r2Idx);

            // 左侧和右侧值的差平方和
            double sumsl = sumSquareLoss(ydata, c1, r1Idx, c2, r2Idx);

            // 找最小的和（冒泡方式）
            if (i == 0 ||  minSum > sumsl) {
                minSum = sumsl;
                brn = new BinaryTreeNode(splitPoint, c1, c2);
                brn.setLeftIdx(r1Idx);
                brn.setRightIdx(r2Idx);
            }
        }
        return brn;
    }
    // 左侧和右侧值的差平方和
    double sumSquareLoss(double[] data, double c1, int[] r1IndexArray, double c2, int[] r2IndexArray) {
        double sum = 0.0d;
        for (int idx : r1IndexArray) {
            if (idx > -1) {
                sum = sum + squareLoss(data[idx], c1);
            }
        }

        for (int idx : r2IndexArray) {
            if (idx > -1) {
                sum = sum + squareLoss(data[idx], c2);
            }
        }

        return sum;
    }

    double meanMatrix1DByIdx(double[] data, int[] indexArray) {
        double ret = 0.0d;
        int count = 0;
        for (int idx : indexArray) {
            if (idx > -1) {
                ret = ret + data[idx];
                count++;
            }
        }
        ret = ret / count;
        return ret;
    }

    // 差平方
    double squareLoss(double y, double predict){

        double loss = y - predict;
        return loss * loss;
    }
}
