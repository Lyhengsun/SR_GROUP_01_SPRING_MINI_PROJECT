INSERT INTO achievements (title, description, badge, xp_required)
VALUES
    ('Beginner Explorer', 'Complete your first habit.', 'bronze-badge.png', 100),
    ('Consistency Champion', 'Log 7 consecutive days of habits.', 'silver-badge.png', 500),
    ('Master Achiever', 'Reach level 10.', 'gold-badge.png', 1000),
    ('Daily Streaker', 'Log habits for 30 consecutive days.', 'platinum-badge.png', 1500),
    ('Habit Hero', 'Complete 10 different habits.', 'diamond-badge.png', 2000),
    ('XP Enthusiast', 'Earn 500 XP in a single day.', 'ruby-badge.png', 500),
    ('Level Up Pro', 'Reach level 5.', 'emerald-badge.png', 300),
    ('Challenge Master', 'Complete all weekly challenges.', 'sapphire-badge.png', 1200),
    ('Social Butterfly', 'Refer 5 friends to the app.', 'amethyst-badge.png', 800),
    ('Ultimate Achiever', 'Unlock all achievements.', 'rainbow-badge.png', 5000);

INSERT INTO achievements (title, description, badge, xp_required)
VALUES
    ('Beginner Explorer', 'Complete your first habit.', 'bronze-badge.png', 100),
    ('Consistency Champion', 'Log 7 consecutive days of habits.', 'silver-badge.png', 500),
    ('Master Achiever', 'Reach level 10.', 'gold-badge.png', 1000),
    ('Daily Streaker', 'Log habits for 30 consecutive days.', 'platinum-badge.png', 1500),
    ('Habit Hero', 'Complete 10 different habits.', 'diamond-badge.png', 2000),
    ('XP Enthusiast', 'Earn 500 XP in a single day.', 'ruby-badge.png', 500),
    ('Level Up Pro', 'Reach level 5.', 'emerald-badge.png', 300),
    ('Challenge Master', 'Complete all weekly challenges.', 'sapphire-badge.png', 1200),
    ('Social Butterfly', 'Refer 5 friends to the app.', 'amethyst-badge.png', 800),
    ('Ultimate Achiever', 'Unlock all achievements.', 'rainbow-badge.png', 5000);


INSERT INTO habits (title, description, frequency, app_user_id)
VALUES
    ('Drink Water', 'Drink at least 2 liters of water daily.', 1, (SELECT app_user_id FROM app_users WHERE username = 'user1')),
    ('Exercise', 'Do 30 minutes of exercise daily.', 1, (SELECT app_user_id FROM app_users WHERE username = 'user1')),
    ('Read Daily', 'Read for 30 minutes every day.', 1, (SELECT app_user_id FROM app_users WHERE username = 'user2')),
    ('Meditate', 'Meditate for 10 minutes daily.', 1, (SELECT app_user_id FROM app_users WHERE username = 'user3')),
    ('Write Journal', 'Write a journal entry daily.', 1, (SELECT app_user_id FROM app_users WHERE username = 'user4')),
    ('Learn New Skill', 'Spend 1 hour learning a new skill.', 1, (SELECT app_user_id FROM app_users WHERE username = 'user5')),
    ('Stretching', 'Stretch for 15 minutes daily.', 1, (SELECT app_user_id FROM app_users WHERE username = 'user6')),
    ('Cook Healthy Meal', 'Cook a healthy meal 3 times a week.', 3, (SELECT app_user_id FROM app_users WHERE username = 'user7')),
    ('Walk 10k Steps', 'Walk at least 10,000 steps daily.', 1, (SELECT app_user_id FROM app_users WHERE username = 'user8')),
    ('Practice Piano', 'Practice piano for 30 minutes daily.', 1, (SELECT app_user_id FROM app_users WHERE username = 'user9'));



INSERT INTO habit_logs (log_date, status, xp_earned, habit_id)
VALUES
    ('2023-10-01', TRUE, 50, (SELECT habit_id FROM habits WHERE title = 'Drink Water')),
    ('2023-10-02', TRUE, 50, (SELECT habit_id FROM habits WHERE title = 'Drink Water')),
    ('2023-10-01', FALSE, 0, (SELECT habit_id FROM habits WHERE title = 'Exercise')),
    ('2023-10-02', TRUE, 50, (SELECT habit_id FROM habits WHERE title = 'Exercise')),
    ('2023-10-01', TRUE, 50, (SELECT habit_id FROM habits WHERE title = 'Read Daily')),
    ('2023-10-01', TRUE, 50, (SELECT habit_id FROM habits WHERE title = 'Meditate')),
    ('2023-10-01', TRUE, 50, (SELECT habit_id FROM habits WHERE title = 'Write Journal')),
    ('2023-10-01', TRUE, 50, (SELECT habit_id FROM habits WHERE title = 'Learn New Skill')),
    ('2023-10-01', TRUE, 50, (SELECT habit_id FROM habits WHERE title = 'Stretching')),
    ('2023-10-01', TRUE, 50, (SELECT habit_id FROM habits WHERE title = 'Cook Healthy Meal'));


INSERT INTO app_user_achievements (app_user_id, achievement_id)
VALUES
    ((SELECT app_user_id FROM app_users WHERE username = 'user1'), (SELECT achievement_id FROM achievements WHERE title = 'Beginner Explorer')),
    ((SELECT app_user_id FROM app_users WHERE username = 'user1'), (SELECT achievement_id FROM achievements WHERE title = 'Consistency Champion')),
    ((SELECT app_user_id FROM app_users WHERE username = 'user2'), (SELECT achievement_id FROM achievements WHERE title = 'Beginner Explorer')),
    ((SELECT app_user_id FROM app_users WHERE username = 'user3'), (SELECT achievement_id FROM achievements WHERE title = 'Beginner Explorer')),
    ((SELECT app_user_id FROM app_users WHERE username = 'user4'), (SELECT achievement_id FROM achievements WHERE title = 'Beginner Explorer')),
    ((SELECT app_user_id FROM app_users WHERE username = 'user5'), (SELECT achievement_id FROM achievements WHERE title = 'Beginner Explorer')),
    ((SELECT app_user_id FROM app_users WHERE username = 'user6'), (SELECT achievement_id FROM achievements WHERE title = 'Beginner Explorer')),
    ((SELECT app_user_id FROM app_users WHERE username = 'user7'), (SELECT achievement_id FROM achievements WHERE title = 'Beginner Explorer')),
    ((SELECT app_user_id FROM app_users WHERE username = 'user8'), (SELECT achievement_id FROM achievements WHERE title = 'Beginner Explorer')),
    ((SELECT app_user_id FROM app_users WHERE username = 'user9'), (SELECT achievement_id FROM achievements WHERE title = 'Beginner Explorer'));