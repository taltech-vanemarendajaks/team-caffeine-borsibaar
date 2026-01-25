# Caffeine
## team members and GitHub usernames
- Andrus Rähni - https://github.com/mugulane
- Ilja Sokolov - https://github.com/ohotnik523
- Martti Remmelgas - https://github.com/dotmartti
- Mathias Ranna - https://github.com/mathiasranna
- Ranno Männikust - https://github.com/s1blik

## Team Workflow
A short description of how the team works with the repository:

## Branches
- Branch naming format: ` <prefix>/<ticket id>-<name of developer>-<brief explanation of what we do in branch> `.
- There are two types of branches: main and development branch. Pushing directly to main is prohibited, 
  instead work shall be done in development branch, reviewed and merged into main with Pull Request.
  Type of development branch is defined with prefix before the name of branch.
- Prefixes used in project and their explanation:
  | Branch pattern | Description                                        |
  |--------------- |----------------------------------------------------|
  | `main`         | Main development branch                            |
  | `feature/*`    | Uus funktsionaalsus                                |
  | `bugfix/*`     | Bugi parandus                                      |
  | `hotfix/*`     | Kiire ja kriitiline parandus                       |
  | `chore/*`      | Tehniline hooldus, refactor, config, cleanup       |
  | `refactor/*`   | Koodi ümberkorraldus ilma funktsionaalse muutuseta |
  | `docs/*`       | Dokumentatsioon                                    |
  | `test/*`       | Testide lisamine/parandamine                       |
  | `ci/*`         | CI/CD, GitHub Actions, pipeline                    |
  | `build/*`      | Build-süsteem, dependency’d                        |
  > Where "*" is remaining branch name.
- Branch names should clearly describe the job that is being done in that branch.

## Commits
- Commit messages must clearly describe what was changed in that commit
- There shouldn't be too many changes in one commit, for more transparent development. 
  (More often commits but smaller is better, than rarer ones and bigger)
- Commits shall be regularly pushed to GitHub, making the developing more transparent.

## Pull Request
- Are reviewed at least by one person
- Review comments shall be clear and fully describing the point of reviewer. 
  There shall not be unclear comments, they should be technically full and respectful.
- Are merged once all review comments are resolved, and all requiremens are satisfied.
- Pull Request is merged only by it's creator.

## Merge strategies used
- Ilja: Used Squash merge strategy, for me it's the most common and clean approach in the sense of 
  development with lots of commits. The main branch is not spammed with commits, only with one and
  most importantly this strategy creates very easily parsable commit message that contains all
  the information about the development on that branch, it is useful for automatization. No issues were incountered
  during merging, the only thing is I needed to get familiralized with GitBucket UI for Pull Requests
- Martti: Used Squash as well, because Andrus used Rebase and I understood from the task that we needed at least two different. But on any other day I've preferred Rebase to avoid additional merge commits and the comment history won't be lost by squashing commits with comments into one blob. But I understand the attractiveness of Squash in case you have hundreds of useless commits with useless comments like "WIP" that you want to hide.
- Andrus: I used rebase purely for learning purposes, to better understand the differences between various merge strategies. From my current experience level, rebase feels valuable in terms of keeping the commit history clean and readable. I also understand that squash becomes especially useful in larger projects, where it helps keep the number of commits manageable and avoids cluttering the history.
  * Later, in another PR I encountered a weird situation where I wanted to Rebase, but Github interface didn't allow. Said there was a conflict. But I could select other two merge strategies. Yet later I could rebase another PR without problems. An anomaly?