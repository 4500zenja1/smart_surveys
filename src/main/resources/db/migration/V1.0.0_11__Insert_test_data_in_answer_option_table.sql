INSERT INTO public."answer_option"
    (id, poll_id, option_text, voted_count, type)
    VALUES (1, 1, 'Extremely satisfied', 0, 'CLOSED'),
           (2, 1, 'Very satisfied', 0, 'CLOSED'),
           (3, 1, 'Somewhat satisfied', 0, 'CLOSED'),
           (4, 1, 'Neutral', 0, 'CLOSED'),
           (5, 1, 'Somewhat dissatisfied', 0, 'CLOSED'),
           (6, 1, 'Very dissatisfied', 0, 'CLOSED'),
           (7, 1, 'Extremely dissatisfied', 0, 'CLOSED'),

           (8, 2, 'Extremely satisfied', 0, 'CLOSED'),
           (9, 2, 'Very satisfied', 0, 'CLOSED'),
           (10, 2, 'Somewhat satisfied', 0, 'CLOSED'),
           (11, 2, 'Neutral', 0, 'CLOSED'),
           (12, 2, 'Somewhat dissatisfied', 0, 'CLOSED'),
           (13, 2, 'Very dissatisfied', 0, 'CLOSED'),
           (14, 2, 'Extremely dissatisfied', 0, 'CLOSED'),

           (15, 3, 'Definitely yes', 0, 'CLOSED'),
           (16, 3, 'Mostly yes', 0, 'CLOSED'),
           (17, 3, 'Somewhat yes', 0, 'CLOSED'),
           (18, 3, 'Neutral', 0, 'CLOSED'),
           (19, 3, 'Somewhat no', 0, 'CLOSED'),
           (20, 3, 'Mostly yes', 0, 'CLOSED'),
           (21, 3, 'Definitely yes', 0, 'CLOSED'),

           (22, 4, 'Extremely satisfied', 0, 'CLOSED'),
           (23, 4, 'Very satisfied', 0, 'CLOSED'),
           (24, 4, 'Somewhat satisfied', 0, 'CLOSED'),
           (25, 4, 'Neutral', 0, 'CLOSED'),
           (26, 4, 'Somewhat dissatisfied', 0, 'CLOSED'),
           (27, 4, 'Very dissatisfied', 0, 'CLOSED'),
           (28, 4, 'Extremely dissatisfied', 0, 'CLOSED'),

           (29, 5, 'Near residential neighborhoods', 0, 'CLOSED'),
           (30, 5, 'In city centers', 0, 'CLOSED'),
           (31, 5, 'Near schools and educational institution', 0, 'CLOSED'),
           (32, 5, 'In underdeveloped or underserved areas', 0, 'CLOSED'),
           (33, 5, 'Along waterfronts or green spaces', 0, 'CLOSED'),
           (34, 5, 'Other (please specify)', 0, 'OPEN'),

           (35, 6, '30 minutes', 0, 'CLOSED'),
           (36, 6, '45 minutes', 0, 'CLOSED'),
           (37, 6, '1 hour', 0, 'CLOSED'),
           (38, 6, '1 hour and 15 minutes', 0, 'CLOSED'),
           (39, 6, '1 hour and 30 minutes', 0, 'CLOSED'),
           (40, 6, 'Other (please specify)', 0, 'OPEN'),

           (41, 7, 'Yes, and I love them', 0, 'CLOSED'),
           (42, 7, 'Yes, but I have some suggestions for improvement', 0, 'CLOSED'),
           (43, 7, 'Yes, but I don''t find them useful', 0, 'CLOSED'),
           (44, 7, 'No, but I plan to try them soon', 0, 'CLOSED'),
           (45, 7, 'No, and I''m not interested in trying them', 0, 'CLOSED'),

           (46, 8, 'Extremely useful', 0, 'CLOSED'),
           (47, 8, 'Very useful', 0, 'CLOSED'),
           (48, 8, 'Somewhat useful', 0, 'CLOSED'),
           (49, 8, 'Neutral', 0, 'CLOSED'),
           (50, 8, 'Somewhat not useful', 0, 'CLOSED'),
           (51, 8, 'Not useful at all', 0, 'CLOSED'),
           (52, 8, 'Not applicable', 0, 'CLOSED'),

           (53, 9, 'Innovation A', 0, 'CLOSED'),
           (54, 9, 'Innovation B', 0, 'CLOSED'),
           (55, 9, 'Innovation C', 0, 'CLOSED'),
           (56, 9, 'Innovation D', 0, 'CLOSED'),
           (57, 9, 'Innovation E', 0, 'CLOSED'),
           (58, 9, 'Other (please specify)', 0, 'OPEN'),

           (59, 10, 'Innovation A', 0, 'CLOSED'),
           (60, 10, 'Innovation B', 0, 'CLOSED'),
           (61, 10, 'Innovation C', 0, 'CLOSED'),
           (62, 10, 'Innovation D', 0, 'CLOSED'),
           (63, 10, 'Innovation E', 0, 'CLOSED'),
           (64, 10, 'Other (please specify)', 0, 'OPEN'),

           (65, 11, 'Multiple times a day', 0, 'CLOSED'),
           (66, 11, 'Daily', 0, 'CLOSED'),
           (67, 11, 'Several times a week', 0, 'CLOSED'),
           (68, 11, 'Weekly', 0, 'CLOSED'),
           (69, 11, 'Several times a month', 0, 'CLOSED'),
           (70, 11, 'Monthly', 0, 'CLOSED'),
           (71, 11, 'Rarely', 0, 'CLOSED'),
           (72, 11, 'Never', 0, 'CLOSED'),

           (73, 12, 'Multiple times a day', 0, 'CLOSED'),
           (74, 12, 'Daily', 0, 'CLOSED'),
           (75, 12, 'Several times a week', 0, 'CLOSED'),
           (76, 12, 'Weekly', 0, 'CLOSED'),
           (77, 12, 'Several times a month', 0, 'CLOSED'),
           (78, 12, 'Monthly', 0, 'CLOSED'),
           (79, 12, 'Rarely', 0, 'CLOSED'),
           (80, 12, 'Never', 0, 'CLOSED'),

           (81, 13, 'Online search', 0, 'CLOSED'),
           (82, 13, 'Social media', 0, 'CLOSED'),
           (83, 13, 'Online advertisment', 0, 'CLOSED'),
           (84, 13, 'Word of mouth', 0, 'CLOSED'),
           (85, 13, 'Traditional media', 0, 'CLOSED'),
           (86, 13, 'In-store or physical location', 0, 'CLOSED'),
           (87, 13, 'Email marketing', 0, 'CLOSED'),
           (88, 13, 'Influencer or blogger', 0, 'CLOSED'),
           (89, 13, 'Other (please specify)', 0, 'OPEN'),

           (90, 14, 'Excellent', 0, 'CLOSED'),
           (91, 14, 'Very good', 0, 'CLOSED'),
           (92, 14, 'Good', 0, 'CLOSED'),
           (93, 14, 'Fair', 0, 'CLOSED'),
           (94, 14, 'Poor', 0, 'CLOSED'),

           (95, 15, 'Exceeded expectations', 0, 'CLOSED'),
           (96, 15, 'Fully met expectations', 0, 'CLOSED'),
           (97, 15, 'Partially met expectations', 0, 'CLOSED'),
           (98, 15, 'Did not meet expectations', 0, 'CLOSED'),
           (99, 15, 'Completely failed to meet expectations', 0, 'CLOSED'),

           (100, 16, 'Children (0-12 years)', 0, 'CLOSED'),
           (101, 16, 'Teens (13-17 years)', 0, 'CLOSED'),
           (102, 16, 'Young adults (18-24 years)', 0, 'CLOSED'),
           (103, 16, 'Adults (25-34 years)', 0, 'CLOSED'),
           (104, 16, 'Adults (35-44 years)', 0, 'CLOSED'),
           (105, 16, 'Adults (45-54 years)', 0, 'CLOSED'),
           (106, 16, 'Adults (55-64 years)', 0, 'CLOSED'),
           (107, 16, 'Seniors (65+ years)', 0, 'CLOSED'),
           (108, 16, 'All ages', 0, 'CLOSED'),

           (109, 17, 'Yes, much more often', 0, 'CLOSED'),
           (110, 17, 'Yes, somewhat more often', 0, 'CLOSED'),
           (111, 17, 'No change needed', 0, 'CLOSED'),
           (112, 17, 'No, somewhat less often', 0, 'CLOSED'),
           (113, 17, 'No, much less often', 0, 'CLOSED'),
           (114, 17, 'Not sure', 0, 'CLOSED');