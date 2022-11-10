-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Φιλοξενητής: 127.0.0.1
-- Χρόνος δημιουργίας: 20 Ιουν 2022 στις 23:17:18
-- Έκδοση διακομιστή: 10.4.14-MariaDB
-- Έκδοση PHP: 7.4.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Βάση δεδομένων: `basketapp`
--

-- --------------------------------------------------------

--
-- Δομή πίνακα για τον πίνακα `games`
--

CREATE TABLE `games` (
  `gameID` bigint(20) UNSIGNED NOT NULL,
  `day` int(11) NOT NULL,
  `homeTeam` varchar(30) NOT NULL,
  `awayTeam` varchar(30) NOT NULL,
  `score` varchar(10) NOT NULL,
  `date` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Άδειασμα δεδομένων του πίνακα `games`
--

INSERT INTO `games` (`gameID`, `day`, `homeTeam`, `awayTeam`, `score`, `date`) VALUES
(1, 2, 'Olympiacos', 'Paok', '-', '2022-10-08 17:00:00'),
(2, 3, 'Panathinaikos', 'Olympiacos', '-', '2022-10-15 17:00:00'),
(3, 4, 'Panathinaikos', 'Paok', '-', '2022-10-22 17:00:00'),
(4, 3, 'Olympiacos', 'Paok', '-', '2022-10-15 17:00:00'),
(5, 2, 'Olympiacos', 'Panathinaikos', '-', '2022-10-08 17:00:00'),
(6, 5, 'Panathinaikos', 'Aris', '-', '2022-10-29 17:00:00'),
(7, 6, 'Panathinaikos', 'Olympiacos', '-', '2022-11-05 17:00:00'),
(8, 1, 'Panathinaikos', 'Paok', '-', '2022-10-01 17:00:00'),
(9, 6, 'Paok', 'Aris', '-', '2022-11-05 17:00:00'),
(10, 5, 'Paok', 'Olympiacos', '-', '2022-10-29 17:00:00'),
(11, 4, 'Paok', 'Panathinaikos', '-', '2022-10-22 17:00:00'),
(27, 1, 'Olympiacos', 'Panathinaikos', '-', '2022-10-01 17:00:00'),
(28, 1, 'Aris', 'Olympiacos', '-', '2022-10-01 17:00:00');

-- --------------------------------------------------------

--
-- Δομή πίνακα για τον πίνακα `players`
--

CREATE TABLE `players` (
  `id` bigint(20) NOT NULL,
  `teamName` varchar(50) NOT NULL,
  `firstname` varchar(50) NOT NULL,
  `lastname` varchar(50) NOT NULL,
  `position` varchar(50) NOT NULL,
  `shots` int(11) NOT NULL,
  `rebounds` int(11) NOT NULL,
  `steals` int(11) NOT NULL,
  `turnovers` int(11) NOT NULL,
  `points` int(11) NOT NULL,
  `1p` int(11) NOT NULL,
  `2p` int(11) NOT NULL,
  `3p` int(11) NOT NULL,
  `fouls` int(11) NOT NULL,
  `assists` int(11) NOT NULL,
  `blocks` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Άδειασμα δεδομένων του πίνακα `players`
--

INSERT INTO `players` (`id`, `teamName`, `firstname`, `lastname`, `position`, `shots`, `rebounds`, `steals`, `turnovers`, `points`, `1p`, `2p`, `3p`, `fouls`, `assists`, `blocks`) VALUES
(1, 'Paok', 'Nate', 'RENFRO ', 'PG', 34, 3, 2, 2, 23, 43, 20, 0, 14, 9, 2),
(2, 'Paok', 'Josh', 'CARTER ', 'SG', 32, 54, 3, 2, 12, 32, 1, 7, 9, 2, 4),
(3, 'Paok', 'MALCOLM', 'GRIFFIN ', 'SF', 123, 3, 4, 3, 11, 7, 20, 8, 10, 30, 5),
(4, 'Paok', 'Antonis', 'KARAGIANNIDIS ', 'PF', 54, 7, 12, 4, 7, 0, 0, 0, 0, 0, 27),
(5, 'Paok', 'Andreas', 'CHRISTODOULOU ', 'C', 45, 36, 12, 5, 34, 46, 27, 8, 20, 17, 25),
(6, 'Paok', 'Dimitri', 'RIVERS ', 'SG', 45, 25, 11, 6, 54, 11, 25, 18, 23, 5, 34),
(7, 'Olympiacos', 'Mustafa', 'FAL', 'SG', 100, 26, 6, 0, 23, 14, 62, 0, 55, 35, 23),
(8, 'Olympiacos', 'Livio', 'JEAN-CHARLES', 'PG', 134, 57, 23, 7, 45, 14, 4, 11, 26, 22, 45),
(9, 'Olympiacos', 'Hassan', 'MARTIN', 'SF', 76, 3, 43, 8, 56, 14, 6, 0, 30, 22, 6),
(10, 'Olympiacos', 'Quincy', 'ΕΙΣΙ ', 'SF', 45, 32, 0, 9, 53, 62, 6, 15, 8, 8, 3),
(11, 'Olympiacos', ' Sakil', 'MAC KISIK', 'PF', 7, 21, 12, 3, 21, 19, 4, 29, 38, 38, 45),
(12, 'Olympiacos', 'Alexander', 'VEZENKOV', 'C', 78, 28, 0, 1, 45, 31, 28, 31, 23, 37, 23),
(13, 'Panathinaikos', 'Ioannis', 'PAPAPETROU ', 'C', 98, 39, 3, 22, 65, 19, 20, 28, 42, 33, 28),
(14, 'Panathinaikos', 'Howard', 'SAINT ROSS', 'PF', 56, 10, 4, 3, 21, 18, 37, 22, 42, 75, 26),
(15, 'Panathinaikos', 'Peyton', 'SIVA ', 'SF', 54, 28, 34, 33, 34, 0, 0, 0, 3, 6, 35),
(16, 'Panathinaikos', 'Stefan', 'JOVICS ', 'SG', 78, 29, 45, 22, 54, 17, 7, 1, 1, 10, 12),
(17, 'Panathinaikos', 'Neoklis', 'ΑΒΔΑΛΑΣ ', 'PF', 76, 2, 0, 4, 12, 8, 1, 2, 1, 2, 34),
(18, 'Panathinaikos', 'CENTRAL', 'Peri ', 'PG', 56, 1, 34, 5, 34, 60, 12, 6, 25, 8, 12),
(41, 'Paok', 'LOVE', 'Jermaine', 'PG', 23, 34, 0, 12, 1, 2, 34, 45, 2, 5, 1),
(42, 'Paok', 'Apostolos', 'ROUMOGLOU', 'SG', 54, 43, 34, 16, 3, 4, 23, 34, 2, 4, 2),
(43, 'Paok', 'Vassilis', 'TOLIOPOULOS', 'PF', 23, 2, 23, 54, 5, 0, 34, 45, 4, 4, 3),
(44, 'Panathinaikos', 'Eleftherios', 'BOCHORIDIS', 'PG', 45, 2, 12, 86, 6, 0, 45, 3, 2, 4, 4),
(45, 'Panathinaikos', 'George', 'PAPAGIANNIS', 'SF', 56, 34, 23, 24, 7, 65, 0, 4, 0, 4, 5),
(46, 'Panathinaikos', 'Dimitrios', 'DEIMEZIS', 'SF', 33, 1, 54, 87, 8, 4, 56, 23, 0, 4, 6),
(47, 'Panathinaikos', 'OCARO', 'WHITE', 'SG', 12, 43, 2, 47, 9, 3, 56, 45, 0, 45, 7),
(48, 'Olympiacos', 'Thomas', 'WOOKAP', 'SG', 2, 4, 6, 8, 0, 5, 43, 45, 45, 56, 45),
(49, 'Olympiacos', 'Sotiris', 'OIKONOMOPOULOS', 'C', 3, 5, 7, 9, 6, 0, 23, 45, 56, 34, 34),
(50, 'Aris', 'Constantine', 'KARAGIANNIS', 'SG', 12, 12, 54, 25, 4, 23, 1, 0, 0, 23, 0),
(51, 'Aris', 'Eric', 'LOCKET', 'PF', 23, 23, 34, 26, 3, 0, 0, 45, 2, 45, 2),
(52, 'Aris', 'Zirius', 'WILLIAMS', 'PF', 54, 7, 0, 34, 2, 23, 2, 8, 34, 2, 34),
(53, 'Aris', 'Michael', 'FINKE', 'SF', 43, 6, 76, 16, 13, 36, 3, 0, 4, 45, 0),
(54, 'Aris', 'Brilliant', 'FRYDAS', 'C', 0, 5, 45, 17, 43, 3, 4, 4, 2, 4, 4),
(55, 'Aris', 'Giannis', 'SIDIROILIAS', 'SG', 23, 4, 34, 19, 24, 0, 5, 4, 0, 2, 34),
(56, 'Aris', 'Thomas', 'KOTTAS', 'PG', 23, 3, 43, 34, 5, 34, 34, 0, 34, 5, 4),
(57, 'Aris', 'Stelios', 'HAVALES', 'C', 34, 4, 34, 54, 5, 6, 6, 45, 1, 2, 16);

-- --------------------------------------------------------

--
-- Δομή πίνακα για τον πίνακα `ranking`
--

CREATE TABLE `ranking` (
  `teamName` varchar(30) NOT NULL,
  `leaguePoints` int(11) NOT NULL,
  `wins` int(11) NOT NULL,
  `defeats` int(11) NOT NULL,
  `pointsDifference` int(11) NOT NULL,
  `gamesPlayed` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Άδειασμα δεδομένων του πίνακα `ranking`
--

INSERT INTO `ranking` (`teamName`, `leaguePoints`, `wins`, `defeats`, `pointsDifference`, `gamesPlayed`) VALUES
('Aris', 10, 1, 15, 11, 16),
('Olympiacos', 35, 10, 6, 35, 16),
('Panathinaikos', 23, 8, 8, 25, 16),
('Paok', 14, 5, 11, 20, 16);

-- --------------------------------------------------------

--
-- Δομή πίνακα για τον πίνακα `teams`
--

CREATE TABLE `teams` (
  `name` varchar(30) NOT NULL,
  `city` varchar(50) NOT NULL,
  `logo` varchar(256) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Άδειασμα δεδομένων του πίνακα `teams`
--

INSERT INTO `teams` (`name`, `city`, `logo`) VALUES
('Aris', 'Thessaloniki', 'https://upload.wikimedia.org/wikipedia/el/thumb/e/e4/Aris_Thessaloniki_F.C._logo.svg/1200px-Aris_Thessaloniki_F.C._logo.svg.png'),
('Olympiacos', 'Athens', 'https://upload.wikimedia.org/wikipedia/en/thumb/7/7f/Olympiacos_BC_logo.svg/1200px-Olympiacos_BC_log.svg.png'),
('Panathinaikos', 'Athens', 'https://upload.wikimedia.org/wikipedia/en/thumb/1/18/Panathinaikos_BC_logo.svg/1200px-Panathinaikos_BC_logo.svg.png'),
('Paok', 'Thessaloniki', 'https://seeklogo.com/images/P/paok-fc-1926-logo-A2A6234575-seeklogo.com.png');

-- --------------------------------------------------------

--
-- Δομή πίνακα για τον πίνακα `teamsstatistics`
--

CREATE TABLE `teamsstatistics` (
  `teamName` varchar(30) NOT NULL,
  `gameID` varchar(20) NOT NULL,
  `shots` int(11) NOT NULL,
  `shotsIn` int(11) NOT NULL,
  `onePointShots` int(11) NOT NULL,
  `onePointShotsIn` int(11) NOT NULL,
  `twoPointsShots` int(11) NOT NULL,
  `twoPointsShotsIn` int(11) NOT NULL,
  `threePointsShots` int(11) NOT NULL,
  `threePointsShotsIn` int(11) NOT NULL,
  `rebounds` int(11) NOT NULL,
  `assists` int(11) NOT NULL,
  `steals` int(11) NOT NULL,
  `blocks` int(11) NOT NULL,
  `fouls` int(11) NOT NULL,
  `points` int(11) NOT NULL,
  `turnovers` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Άδειασμα δεδομένων του πίνακα `teamsstatistics`
--

INSERT INTO `teamsstatistics` (`teamName`, `gameID`, `shots`, `shotsIn`, `onePointShots`, `onePointShotsIn`, `twoPointsShots`, `twoPointsShotsIn`, `threePointsShots`, `threePointsShotsIn`, `rebounds`, `assists`, `steals`, `blocks`, `fouls`, `points`, `turnovers`) VALUES
('Panathinaikos', '1', 72, 49, 2, 2, 50, 38, 20, 9, 35, 14, 4, 6, 8, 105, 9),
('Panathinaikos', '4', 76, 44, 14, 10, 40, 25, 22, 9, 23, 18, 2, 5, 15, 87, 5),
('Olympiacos', '1', 67, 47, 7, 6, 45, 36, 15, 5, 21, 15, 3, 4, 12, 93, 6),
('Paok', '4', 23, 14, 12, 34, 21, 43, 2, 65, 52, 34, 23, 45, 32, 23, 23),
('Aris', '5', 23, 34, 2, 34, 56, 34, 23, 12, 45, 67, 34, 32, 56, 23, 34);

--
-- Ευρετήρια για άχρηστους πίνακες
--

--
-- Ευρετήρια για πίνακα `games`
--
ALTER TABLE `games`
  ADD UNIQUE KEY `id` (`gameID`);

--
-- Ευρετήρια για πίνακα `players`
--
ALTER TABLE `players`
  ADD PRIMARY KEY (`id`);

--
-- Ευρετήρια για πίνακα `ranking`
--
ALTER TABLE `ranking`
  ADD PRIMARY KEY (`teamName`);

--
-- Ευρετήρια για πίνακα `teams`
--
ALTER TABLE `teams`
  ADD PRIMARY KEY (`name`);

--
-- AUTO_INCREMENT για άχρηστους πίνακες
--

--
-- AUTO_INCREMENT για πίνακα `games`
--
ALTER TABLE `games`
  MODIFY `gameID` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=29;

--
-- AUTO_INCREMENT για πίνακα `players`
--
ALTER TABLE `players`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=58;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
