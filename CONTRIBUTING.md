# Contributing to Java Dev

Thanks for considering contributing to **Java Dev** — a Java-based Developer Tools Service evolving into a backend platform for automating and standardizing everyday engineering tasks.

This document explains how to contribute in a way that’s clear, respectful, and aligned with the project’s goals.

## How You Can Contribute

You can help by:

- Reporting bugs or unexpected behaviour  
- Suggesting new features or improvements  
- Improving documentation (README, guides, examples)  
- Submitting code changes (fixes, features, refactors)  
- Sharing feedback on design and direction  

## Before You Start

1. **Check existing issues and discussions**  
   Search the repository to see if your idea or bug has already been reported.

2. **Open an issue or discussion**  
   For non-trivial changes (new features, big refactors, new modules), open an issue or discussion first to align on approach.

3. **Make sure you’re comfortable with the Code of Conduct**  
   This project follows a Code of Conduct to ensure a welcoming and respectful environment for everyone.

## Setting Up Your Environment

1. Fork the repository.
2. Clone your fork locally:

   ```bash
   git clone https://github.com/<your-username>/java-dev.git
   cd java-dev
   ```

3. Install dependencies and build the project using your chosen build tool (Maven or Gradle).
4. Run tests to confirm everything works before making changes.

## Making Changes

1. **Create a feature branch**

   ```bash
   git checkout -b feat/your-feature-name
   ```

   Use clear branch names, e.g.:
   - `feat/add-scaffolding-util`
   - `fix/resolve-null-pointer-in-validator`
   - `docs/improve-readme-setup`

2. **Write clear, focused commits**
   - Keep commits small and logically grouped.
   - Write meaningful commit messages (what changed and why).

3. **Follow the project’s coding style**
   - Use existing code as a guide for naming, structure, and formatting.
   - Run linting and formatting tools if configured.

4. **Add or update tests**
   - Include tests for new functionality.
   - Ensure existing tests still pass.

5. **Update documentation**
   - Update README, module docs, or examples if behaviour or usage changes.

## Submitting a Pull Request

1. Push your branch to your fork:

   ```bash
   git push origin feat/your-feature-name
   ```

2. Open a pull request (PR) against the `main` branch of this repository.
3. In your PR description, include:
   - What this change does  
   - Why it’s needed  
   - Any relevant issue/discussion links  
   - Notes on testing (what you tested, how)

4. Be open to feedback and iterate on the PR as needed.

## Code Review Expectations

- Reviews focus on correctness, clarity, maintainability, and alignment with the project’s vision.
- Be respectful and constructive in comments.
- Treat reviews as a collaboration, not a judgment.

## Reporting Bugs

When reporting a bug, include:

- A clear title and description  
- Steps to reproduce  
- Expected vs actual behaviour  
- Environment details (Java version, OS, build tool, etc.)  
- Any relevant logs or stack traces  

## Suggesting Features

When suggesting a feature, include:

- The problem you’re trying to solve  
- A description of the proposed solution  
- Examples of how it would be used  
- Any trade-offs or alternatives you’ve considered  

## Questions or Need Help?

If you’re unsure about something:

- Open a discussion asking for guidance  
- Refer to existing issues and PRs for examples  

Your contributions help make Java Dev more useful and sustainable. Thank you for investing your time and energy in this project.
