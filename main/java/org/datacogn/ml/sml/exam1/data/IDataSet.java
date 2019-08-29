package org.datacogn.ml.sml.exam1.data;

import java.util.List;

public interface IDataSet {
	public List<List<Double>> getDatas() ;
	public List<Double> getLabels() ;
	public List<List<Object>> getDatasets() ;
	public Integer getSize();	
}
