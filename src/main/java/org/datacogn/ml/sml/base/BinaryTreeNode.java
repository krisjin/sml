package org.datacogn.ml.sml.base;

/**
 * User:krisjin
 * Date:2019-11-06
 */
public class BinaryTreeNode {

    // 拆分点
    double splitPoint;
    // 拆分点左边的数据的均值，包含拆分点
    double leftValue; // include the splitValue
    // 拆分点左边元素的索引
    int[] leftIdx;
    // 拆分点左边的数据的均值
    double rightValue;
    // 拆分点右边元素的索引
    int[] rightIdx;
}
