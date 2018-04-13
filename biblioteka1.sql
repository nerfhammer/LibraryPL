-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Czas generowania: 13 Kwi 2018, 13:08
-- Wersja serwera: 10.1.29-MariaDB
-- Wersja PHP: 7.2.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Baza danych: `biblioteka1`
--

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `czytelnik`
--

CREATE TABLE `czytelnik` (
  `id_czytelnika` int(11) NOT NULL,
  `imie` varchar(255) COLLATE utf8_polish_ci DEFAULT NULL,
  `nazwisko` varchar(255) COLLATE utf8_polish_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci;

--
-- Zrzut danych tabeli `czytelnik`
--

INSERT INTO `czytelnik` (`id_czytelnika`, `imie`, `nazwisko`) VALUES
(3, 'Michal', 'Malinowski'),
(4, 'Adam', 'Rura'),
(5, 'Monika', 'Tralalala'),
(6, 'Marian', 'Marianowski'),
(8, 'Adriana', 'Pisarska'),
(9, 'Kura', 'Pazurem'),
(10, 'Antoni', 'Macierewicz'),
(11, 'dr Wojciech', 'Koziol'),
(13, 'Adam', 'Kuszewski'),
(15, 'Micha? Jakub', 'Malkontencki'),
(16, 'Olgierd', '?ukasiewicz'),
(18, 'Garfield ', 'Garfieldowicz'),
(19, 'Goran', 'Relji?'),
(20, 'Agnieszka', 'Kaczorowska'),
(21, 'Dariusz', 'Michalczewski'),
(22, 'Micha?', 'Dariuszewski'),
(23, 'Micha?', 'Malinowski'),
(24, 'asdasdd', 'qweqwe'),
(25, 'Marian', 'Kowalski'),
(26, 'Gertruda', 'Malinowska'),
(27, 'Adam', 'Kownacki'),
(28, 'Piotr', 'Macedo?ski'),
(29, 'asdasd', 'qweeqwe'),
(30, 'Bartek', 'Tarnawski');

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `ksiazka`
--

CREATE TABLE `ksiazka` (
  `id_ksiazki` int(11) NOT NULL,
  `autor` varchar(255) COLLATE utf8_polish_ci DEFAULT NULL,
  `dostepnosc` bit(1) DEFAULT NULL,
  `tytul` varchar(255) COLLATE utf8_polish_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci;

--
-- Zrzut danych tabeli `ksiazka`
--

INSERT INTO `ksiazka` (`id_ksiazki`, `autor`, `dostepnosc`, `tytul`) VALUES
(1, 'B. Gordon', b'0', 'Jak nastroic skrzypce'),
(3, 'R. Mak?owicz', b'1', '2 sposoby na sadzone jajko. Poradnik dla opornych'),
(5, 'A. Mickiewicz', b'0', 'Pan Tadeusz'),
(10, 'M. Plecak', b'1', 'Czerwone i bure'),
(11, 'Microsoft', b'0', 'Visual Studio Enterprise - User Guide'),
(14, 'Major Zag?oba', b'1', 'Tego si? nie spodziewa?e?, Tuchajbej!'),
(16, 'A. Sitko, B. Andrusz', b'1', 'Praca zbiorowa'),
(17, 'M. Atematyka', b'1', 'Wszystko o zbiorach'),
(18, 'R. Olnik', b'1', 'Zbiory malin truskawek i porzeczek'),
(21, 'Newt Scamander', b'0', 'Fantastyczne zwierz?ta i jak je znale??'),
(23, 'M. Kot', b'0', 'Jak skaka? i si? nie wyskaka?'),
(24, 'C. Gordon', b'1', 'Jak nastroi? skrzypce'),
(25, 'M. Kowalewski', b'0', 'Olga'),
(26, 'M. Hippe', b'1', 'Nie umiem nic'),
(27, 'dr E. Nidecka', b'1', 'Te? nic nie umiem'),
(28, 'M. Kaku', b'1', 'Fizyka j?drowa'),
(29, 'H. Konda', b'1', 'Falas'),
(30, 'B. Walaszek', b'1', 'W?ciek?e Pi??ci W??a'),
(31, 'B. Walaszek', b'0', 'Sarnie ?niwo, czyli pokusa statuetkowego szlaku'),
(32, 'K. Wejk', b'1', 'Best of memes'),
(33, 'asdasdas', b'1', 'asfasfasf'),
(34, 'asdasd', b'1', 'asdasdsd');

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `wypozyczenia`
--

CREATE TABLE `wypozyczenia` (
  `id_wypozyczenia` int(11) NOT NULL,
  `data_wyp` datetime DEFAULT NULL,
  `data_zwr` datetime DEFAULT NULL,
  `id_czytelnika` int(11) DEFAULT NULL,
  `id_ksiazki` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci;

--
-- Zrzut danych tabeli `wypozyczenia`
--

INSERT INTO `wypozyczenia` (`id_wypozyczenia`, `data_wyp`, `data_zwr`, `id_czytelnika`, `id_ksiazki`) VALUES
(2, '2018-03-14 18:23:43', NULL, 9, 23),
(3, '2018-03-14 18:23:47', NULL, 21, 25),
(4, '2018-03-14 18:23:52', NULL, 26, 31),
(5, '2018-03-14 18:23:56', NULL, 26, 5),
(6, '2018-03-14 18:23:59', NULL, 3, 1),
(7, '2018-03-14 19:00:05', NULL, 23, 21),
(8, '2018-03-14 19:06:05', NULL, 18, 11);

--
-- Indeksy dla zrzutów tabel
--

--
-- Indexes for table `czytelnik`
--
ALTER TABLE `czytelnik`
  ADD PRIMARY KEY (`id_czytelnika`);

--
-- Indexes for table `ksiazka`
--
ALTER TABLE `ksiazka`
  ADD PRIMARY KEY (`id_ksiazki`);

--
-- Indexes for table `wypozyczenia`
--
ALTER TABLE `wypozyczenia`
  ADD PRIMARY KEY (`id_wypozyczenia`),
  ADD KEY `FK_4uk3n58i0xuwrsjsp7m16acdl` (`id_czytelnika`),
  ADD KEY `FK_kj0k6ehls3ht6mhbbbivbqatp` (`id_ksiazki`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT dla tabeli `czytelnik`
--
ALTER TABLE `czytelnik`
  MODIFY `id_czytelnika` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=31;

--
-- AUTO_INCREMENT dla tabeli `ksiazka`
--
ALTER TABLE `ksiazka`
  MODIFY `id_ksiazki` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=35;

--
-- AUTO_INCREMENT dla tabeli `wypozyczenia`
--
ALTER TABLE `wypozyczenia`
  MODIFY `id_wypozyczenia` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
