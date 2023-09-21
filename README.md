# Treasure Hunt Game

Welcome to the Treasure Hunt Game! This Java application allows you to simulate adventurers exploring a map and collecting treasures.

## Table of Contents
- [Getting Started](#getting-started)
- [Prerequisites](#prerequisites)
- [Installation](#installation)
- [Usage](#usage)
- [File Formats](#file-formats)

## Getting Started

This section provides an overview of how to set up and use the Treasure Hunt Game.

### Prerequisites

Before running the application, you need to have the following software installed on your system:

- Java Development Kit (JDK) 8 or higher

### Installation

1. Clone the repository to your local machine:

   ```bash
   git clone https://github.com/SyrineBen/carbonit

2. maven install 

### Usage

To run the Treasure Hunt Game, use the following command:
 ```bash
   java com.carbonit.treasure.App
   ```
The application will prompt you to enter the input and output file names.


### File Formats
#### File input format

The input file should contain data to initialize the map, mountains, treasures, and adventurers. Here's an example of the input file format:

 ```bash
C - 3 - 4        # Create a map with a width of 3 and a height of 4
M - 1 - 0        # Add a mountain at coordinates (1, 0)
T - 0 - 3 - 2    # Add a treasure at coordinates (0, 3) with 2 treasures
A - Lara - 1 - 1 - S - AADADA    # Add an adventurer named Lara
 ```

#### File output format
The application will generate an output file with the final state of the map and adventurers.



