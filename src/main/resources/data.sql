INSERT INTO app_users (username, email, password, level, xp, profile_image, is_verified)
VALUES
    ('alice', 'alice@example.com', 'password123', 5, 500, 'https://example.com/profiles/alice.jpg', TRUE),
    ('bob', 'bob@example.com', 'securepass', 3, 300, NULL, TRUE),
    ('charlie', 'charlie@example.com', 'mypassword', 1, 50, 'https://example.com/profiles/charlie.jpg', FALSE),
    ('diana', 'diana@example.com', 'dianapass', 7, 750, 'https://example.com/profiles/diana.jpg', TRUE),
    ('eve', 'eve@example.com', 'evepass', 2, 200, NULL, TRUE),
    ('frank', 'frank@example.com', 'frankpass', 4, 400, 'https://example.com/profiles/frank.jpg', TRUE),
    ('grace', 'grace@example.com', 'gracepass', 6, 600, NULL, FALSE),
    ('hannah', 'hannah@example.com', 'hannahpass', 8, 850, 'https://example.com/profiles/hannah.jpg', TRUE),
    ('ivan', 'ivan@example.com', 'ivanpass', 9, 950, NULL, TRUE),
    ('julia', 'julia@example.com', 'juliapass', 10, 1000, 'https://example.com/profiles/julia.jpg', TRUE);


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
    ('Drink Water', 'Drink at least 2 liters of water daily.', 1, 1), -- Alice's habit
    ('Exercise', 'Do 30 minutes of exercise daily.', 1, 1), -- Alice's habit
    ('Read Daily', 'Read for 30 minutes every day.', 1, 2), -- Bob's habit
    ('Meditate', 'Meditate for 10 minutes daily.', 1, 3), -- Charlie's habit
    ('Write Journal', 'Write a journal entry daily.', 1, 4), -- Diana's habit
    ('Learn New Skill', 'Spend 1 hour learning a new skill.', 1, 5), -- Eve's habit
    ('Stretching', 'Stretch for 15 minutes daily.', 1, 6), -- Frank's habit
    ('Cook Healthy Meal', 'Cook a healthy meal 3 times a week.', 3, 7), -- Grace's habit
    ('Walk 10k Steps', 'Walk at least 10,000 steps daily.', 1, 8), -- Hannah's habit
    ('Practice Piano', 'Practice piano for 30 minutes daily.', 1, 9); -- Ivan's habit


INSERT INTO habit_logs (log_date, status, xp_earned, habit_id)
VALUES
    ('2023-10-01', TRUE, 50, 1), -- Alice completed "Drink Water" on Oct 1
    ('2023-10-02', TRUE, 50, 1), -- Alice completed "Drink Water" on Oct 2
    ('2023-10-01', FALSE, 0, 2), -- Alice missed "Exercise" on Oct 1
    ('2023-10-02', TRUE, 50, 2), -- Alice completed "Exercise" on Oct 2
    ('2023-10-01', TRUE, 50, 3), -- Bob completed "Read Daily" on Oct 1
    ('2023-10-01', TRUE, 50, 4), -- Charlie completed "Meditate" on Oct 1
    ('2023-10-01', TRUE, 50, 5), -- Diana completed "Write Journal" on Oct 1
    ('2023-10-01', TRUE, 50, 6), -- Eve completed "Learn New Skill" on Oct 1
    ('2023-10-01', TRUE, 50, 7), -- Frank completed "Stretching" on Oct 1
    ('2023-10-01', TRUE, 50, 8); -- Grace completed "Cook Healthy Meal" on Oct 1


INSERT INTO app_user_achievements (app_user_id, achievement_id)
VALUES
    (5, 1), -- Alice earned "Beginner Explorer"
    (5, 2), -- Alice earned "Consistency Champion"
    (7, 1), -- Bob earned "Beginner Explorer"
    (3, 1), -- Charlie earned "Beginner Explorer"
    (4, 1), -- Diana earned "Beginner Explorer"
    (5, 1), -- Eve earned "Beginner Explorer"
    (6, 1), -- Frank earned "Beginner Explorer"
    (7, 1), -- Grace earned "Beginner Explorer"
    (8, 1), -- Hannah earned "Beginner Explorer"
    (9, 1); -- Ivan earned "Beginner Explorer"
