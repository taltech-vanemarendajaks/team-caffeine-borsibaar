# Homework Hand-in document

## Homework 2 - Git


### Common parts

* Part 1: Repository setup
  * Step 1: Fork the repository
    + fork completed along with migration under common org
  * Step 2: Clone the repository
    + DONE everybody works in their local clone

  * Step 3: Initial Commit
    The initial commit concerning with TEAM.md:
    https://github.com/taltech-vanemarendajaks/team-caffeine-borsibaar/commit/14d0d29e282dcdc3178474a5e1ba42c7450b59c6

    But this didn't resolve the whole step. The TEAM.md was describe in full after a team meeting at 2026-01-22 in PR https://github.com/taltech-vanemarendajaks/team-caffeine-borsibaar/pull/20

* Part 2: Branching and parallel development
  * Step 4: Define features
    + We decided each should have their own issue and they will define the feature themselves that they're working on.

* Part 5: Merging strategies (in GitHub GUI)
  * Step 11: Use different merge types
    + We used at least Squash and Rebase
  * Step 12: Explain your choices
    + Updated TEAM.md with comments https://github.com/taltech-vanemarendajaks/team-caffeine-borsibaar/pull/29

* Part 6: Final cleanup
  * Step 13: Repository hygiene
    + Delete merged feature branches
    + Ensure main contains all final changes
  * Step 14: Documentation
    + Create a file HANDIN.md
    + Include links to PR, explain conflicts, what each team member worked on.


### Mugulane (Andrus Rähni)

* Part 2: Branching and parallel development

  * Step 5: Create feature branch
  * Step 6: Work on features
  * Step 9: Open pull request
  * Step 10: Review pull requests
  * Step 11: Use different merge types

  These steps were completed within PR https://github.com/taltech-vanemarendajaks/team-caffeine-borsibaar/pull/20

* Part 3: Creating and resolving conflicts
  * Step 7: Intentionally create a conflict
  * Step 8: Resolve the conflict

I simulated a conflict with Martti in creating the HANDIN.md file itself. It was quite late at night, so it was quite hard to follow what one did or did not do.
https://github.com/taltech-vanemarendajaks/team-caffeine-borsibaar/pull/27

For later notice - do not work late at night and/or when you are tired.
Resolved conflicts locally using the command line. Removing "<<<<<<<" ">>>>>>>" markers. 
Conflicts are less likely when you fetch frequently and avoid modifying the same lines.


### ohotnik523 (Ilja Sokolov)

* Part 2: Branching and parallel development

  * Step 5: Create feature branch
  * Step 6: Work on features
  * Step 9: Open pull request
  * Step 10: Review pull requests
  * Step 11: Use different merge types

  These steps were completed within PR https://github.com/taltech-vanemarendajaks/team-caffeine-borsibaar/pull/20

* Part 3: Creating and resolving conflicts
  * Step 7: Intentionally create a conflict
  * Step 8: Resolve the conflict

  My first merge conflict occurred in this pull request:
  https://github.com/taltech-vanemarendajaks/team-caffeine-borsibaar/pull/20

  The conflict happened after I amended a commit message that had already been pushed to the remote repository. Since amending a commit rewrites history, my local branch diverged from the remote one. When I ran git pull, Git detected conflicts in my own files.

  I resolved the conflict by manually reviewing the files and keeping the correct final version of the code. I chose this approach because the branch had already been pushed and was used in a pull request. Using rebase on published commits would rewrite shared history and could cause additional confusion or conflicts for collaborators.

  The main conflict occurred in this pull request:
  https://github.com/taltech-vanemarendajaks/team-caffeine-borsibaar/pull/32

  The conflict occurred because the branch was intentionally created from an older version of the repository where the HANDIN section did not exist. After copying the HANDIN content into this branch and changing the order of sections in the document, a conflict was created.

  I resolved the conflict using git rebase and manual conflict resolution. I chose rebase because I wanted to replay my changes on top of the updated branch and keep a linear and clean commit history, which was suitable in this case since the changes were only on my branch.

### dotmartti

* Part 2: Branching and parallel development

  * Step 5: Create feature branch
  * Step 6: Work on features
  * Step 9: Open pull request
  * Step 10: Review pull requests
  * Step 11: Use different merge types

  These steps were completed within PR https://github.com/taltech-vanemarendajaks/team-caffeine-borsibaar/pull/21

* Part 3: Creating and resolving conflicts

  * Step 7: Intentionally create a conflict
  * Step 8: Resolve the conflict

We simulated a conflict in creating the HANDIN.md file itself.
Initial creation PR https://github.com/taltech-vanemarendajaks/team-caffeine-borsibaar/pull/24

PR where dotmartti resolved his conflict locally using the command line (and almost forgot the merge conflict marker "<<<<<<< HEAD" into the file) https://github.com/taltech-vanemarendajaks/team-caffeine-borsibaar/pull/25


### MathiasRanna

* Part 2: Branching and parallel development

  * Step 5: Create feature branch -> `feature/refactor-category-service`
  * Step 6: Work on features
  * Step 9: Open pull request -> https://github.com/taltech-vanemarendajaks/team-caffeine-borsibaar/pull/9
  * Step 10: Review pull requests -> https://github.com/taltech-vanemarendajaks/team-caffeine-borsibaar/pull/8


* Part 3: Creating and resolving conflicts

  * Step 7: Intentionally create a conflict -> Conflict created by Ilja https://github.com/taltech-vanemarendajaks/team-caffeine-borsibaar/pull/34
  * Step 8: Resolve the conflict -> Resolved the conflict by rebase
  * Step 11: Use different merge types in team -> Team used Squash merge, I used rebase based merge
https://github.com/taltech-vanemarendajaks/team-caffeine-borsibaar/pull/9
