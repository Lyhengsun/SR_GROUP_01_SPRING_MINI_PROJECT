create database habit_tracker_db;
CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

drop table achievements;
drop table app_user_achievements;
drop table habit_logs;
drop table habits;
drop table app_users;
-- Create app_users table
CREATE TABLE IF NOT EXISTS app_users
(
    app_user_id   uuid PRIMARY KEY DEFAULT uuid_generate_v4(),
    username      VARCHAR(255) UNIQUE NOT NULL,
    email         VARCHAR(255) UNIQUE NOT NULL,
    password      VARCHAR(255)        NOT NULL,
    level         INTEGER          DEFAULT 0,
    xp            INTEGER          DEFAULT 0,
    profile_image VARCHAR(255),
    is_verified   BOOLEAN          DEFAULT TRUE,
    created_at    TIMESTAMP        DEFAULT CURRENT_TIMESTAMP
);
insert into app_users (username, email, password, profile_image)
values ('lkjhgfds', 'iuytr@com', md5('1234'), 'llllll');

-- Create achievements table
CREATE TABLE IF NOT EXISTS achievements
(
    achievement_id uuid PRIMARY KEY DEFAULT uuid_generate_v4(),
    title          VARCHAR(255) NOT NULL,
    description    TEXT,
    badge          VARCHAR(255),
    xp_required    INTEGER      NOT NULL
);

-- Create habits table
CREATE TABLE IF NOT EXISTS habits
(
    habit_id    uuid PRIMARY KEY DEFAULT uuid_generate_v4(),
    title       VARCHAR(255) NOT NULL,
    description TEXT,
    frequency   VARCHAR(100)      NOT NULL,
    app_user_id uuid      NOT NULL,
    CONSTRAINT fk_app_users FOREIGN KEY (app_user_id) REFERENCES app_users (app_user_id) ON DELETE CASCADE ON UPDATE CASCADE,
    created_at  TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Create habit_logs table
CREATE TABLE IF NOT EXISTS habit_logs
(
    habit_log_id uuid PRIMARY KEY DEFAULT uuid_generate_v4(),
    log_date     DATE NOT NULL DEFAULT CURRENT_DATE,
    status       VARCHAR(100) NOT NULL,
    xp_earned    INTEGER NOT NULL DEFAULT 0,
    habit_id     uuid NOT NULL,
    CONSTRAINT fk_habits FOREIGN KEY (habit_id) REFERENCES habits (habit_id) ON DELETE CASCADE ON UPDATE CASCADE
);

-- Create app_user_achievements table
CREATE TABLE IF NOT EXISTS app_user_achievements
(
    app_user_achievement_id uuid PRIMARY KEY DEFAULT uuid_generate_v4(),
    app_user_id             uuid NOT NULL,
    achievement_id          uuid NOT NULL,
    CONSTRAINT fk_app_users FOREIGN KEY (app_user_id) REFERENCES app_users (app_user_id) ON DELETE CASCADE ON UPDATE CASCADE,
    CONSTRAINT fk_achievements FOREIGN KEY (achievement_id) REFERENCES achievements (achievement_id) ON DELETE CASCADE ON UPDATE CASCADE
);