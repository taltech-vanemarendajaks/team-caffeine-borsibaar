# Homework Hand-in document

## Homework 2 - Git


### Common parts

* Part 1: Repository setup
  * Steps 1-2 DONE for everybody already.

  * Step 3: Initial Commit
The initial commit concerning with TEAM.md:
https://github.com/taltech-vanemarendajaks/team-caffeine-borsibaar/commit/14d0d29e282dcdc3178474a5e1ba42c7450b59c6

But this didn't resolve the whole step. The TEAM.md was describe in full after a team meeting at 2026-01-22 in PR https://github.com/taltech-vanemarendajaks/team-caffeine-borsibaar/pull/20

* Part 2: Branching and parallel development
  * Step 4: Define features
We decided each should have their own issue and they will define the feature themselves that they're working on.

### Mugulane

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

PR where dotmartti resolved his conflict https://github.com/taltech-vanemarendajaks/team-caffeine-borsibaar/pull/25