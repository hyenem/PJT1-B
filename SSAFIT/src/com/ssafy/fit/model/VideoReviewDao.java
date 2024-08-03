package com.ssafy.fit.model;

import java.util.*;
import com.ssafy.fit.model.*;

public interface VideoReviewDao {
	
	int insertReview(VideoReview videoReview);
	
	List<VideoReview> selectReview(int videoNo);


}
